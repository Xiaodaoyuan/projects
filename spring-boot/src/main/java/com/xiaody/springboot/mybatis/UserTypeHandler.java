package com.xiaody.springboot.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import com.xiaody.springboot.model.enums.UserType;
import com.xiaody.springboot.util.EnumRegistry;

@Component
public class UserTypeHandler extends BaseTypeHandler<UserType>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UserType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getId());
	}

	@Override
	public UserType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int i = rs.getInt(columnName);
		if (rs.wasNull()) {
			return null;
		} else {
			try {
				return EnumRegistry.resolve(i, UserType.class);
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot convert " + i + " to UserType by id value.", e);
			}
		}
	}

	@Override
	public UserType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int i = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else {
			try {
				return EnumRegistry.resolve(i, UserType.class);
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot convert " + i + " to UserType by id value.", e);
			}
		}
	}

	@Override
	public UserType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int i = cs.getInt(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else {
			try {
				return EnumRegistry.resolve(i, UserType.class);
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot convert " + i + " to UserType by id value.", e);
			}
		}
	}

}
