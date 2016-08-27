package com.xiaody.application.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.xiaody.application.model.vo.Page;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class })})
public class PageInterceptor implements Interceptor {

	private final static String SELECT_REGEX = ".+ByPage$";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// ����StatementHandler��ʵֻ������ʵ���࣬һ����RoutingStatementHandler����һ���ǳ�����BaseStatementHandler��
		// BaseStatementHandler���������࣬�ֱ���SimpleStatementHandler��PreparedStatementHandler��CallableStatementHandler��
		// SimpleStatementHandler�����ڴ���Statement�ģ�PreparedStatementHandler�Ǵ���PreparedStatement�ģ���CallableStatementHandler�Ǵ���CallableStatement�ġ�
		// Mybatis�ڽ���Sql��䴦���ʱ���ǽ�����RoutingStatementHandler��
		// ����RoutingStatementHandler����ӵ��һ��StatementHandler���͵�delegate���ԣ�
		// RoutingStatementHandler������Statement�Ĳ�ͬ������Ӧ��BaseStatementHandler����SimpleStatementHandler��

		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		String selectId = mappedStatement.getId();
		if (selectId.matches(SELECT_REGEX)) {
			BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			Page page = (Page) parameter.get("option");
			String sql = boundSql.getSql();
			// ��д��ѯcount��sql
			String countSql = buildCountSql(sql);
			// ��ȡ����
			Connection con = (Connection) invocation.getArgs()[0];
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(countSql);
				rs = ps.executeQuery();
				if (rs.next()) {
					page.setTotalNum(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			}
			// ��д��ҳsql
			String pageSql = buildPageSql(sql, page);
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

	private String buildCountSql(String sql) {
		StringBuffer sb = new StringBuffer("select count(*) from ");
		sql = sql.toLowerCase();

		if (sql.lastIndexOf("order") > sql.lastIndexOf(")")) {
			sb.append(sql.substring(sql.indexOf("from") + 4, sql.lastIndexOf("order")));
		} else {
			sb.append(sql.substring(sql.indexOf("from") + 4));
		}
		return sb.toString();
	}

	private String buildPageSql(String sql, Page page) {
		StringBuffer strBuf = new StringBuffer(sql);
		strBuf.append(" limit ").append(page.getPageSize()).append(" offset ").append(page.getPageStart());
		return strBuf.toString();
	}

}
