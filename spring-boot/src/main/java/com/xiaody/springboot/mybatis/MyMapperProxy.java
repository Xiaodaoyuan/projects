package com.xiaody.springboot.mybatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.SqlSession;

public class MyMapperProxy<T> implements InvocationHandler, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855467147315016560L;

	private final SqlSession sqlSession;
	private final Class<T> mapperInterface;
	private final Map<Method, MapperMethod> methodCache;

	public MyMapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) {
		this.sqlSession = sqlSession;
		this.mapperInterface = mapperInterface;
		this.methodCache = methodCache;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {
			try {
				return method.invoke(this, args);
			} catch (Throwable t) {
				throw ExceptionUtil.unwrapThrowable(t);
			}
		}

		final MapperMethod mapperMethod = cachedMapperMethod(method);

		// if (method.getReturnType() == Results.class) {
		// return processResultsReturn(proxy, method, args);
		// }

		String methodName = method.getName();
		SqlCommandType commandType = getCommandType(methodName, sqlSession);
		
		// pre-process model
       // preHijackModel(args, commandType);

        Object result = mapperMethod.execute(sqlSession, args);

        // post-process model
        //postHijackModel(args);

		return mapperMethod.execute(sqlSession, args);
	}

	private MapperMethod cachedMapperMethod(Method method) {
		MapperMethod mapperMethod = methodCache.get(method);
		if (mapperMethod == null) {
			mapperMethod = new MapperMethod(mapperInterface, method, sqlSession.getConfiguration());
			methodCache.put(method, mapperMethod);
		}
		return mapperMethod;
	}
	
	private SqlCommandType getCommandType(String methodName, SqlSession session) {
        return session.getConfiguration().getMappedStatement(
                this.mapperInterface.getName() + "." + methodName).getSqlCommandType();
    }

}
