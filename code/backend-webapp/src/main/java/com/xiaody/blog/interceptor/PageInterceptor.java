package com.xiaody.blog.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import com.xiaody.blog.model.vo.Page;
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
import org.springframework.stereotype.Component;


/**
 * Created by Xiaody on 2016/9/29.
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {

    private final static String SELECT_REGEX = ".+ByPage$";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，
        // BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，
        // SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是处理CallableStatement的。
        // Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，
        // 而在RoutingStatementHandler里面拥有一个StatementHandler类型的delegate属性，
        // RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String selectId = mappedStatement.getId();
        if (selectId.matches(SELECT_REGEX)) {
            BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
            Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) parameter.get("options");
            String sql = boundSql.getSql();
            // 重写查询count的sql
            String countSql = buildCountSql(sql);
            // 获取连接
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
            // 重写分页sql
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
