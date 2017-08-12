package com.xiaody.spring_boot.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Xiaody on 17/7/26.
 */
public class EncryptTypeHandler extends BaseTypeHandler<String> {
    private Logger logger = LoggerFactory.getLogger(EncryptTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("userId is :{}", CacheUtil.getUserID());
        ps.setString(i, Utils.encryptBase64(s));
    }

    @Override
    public String getNullableResult(ResultSet rs, String s) throws SQLException {
        logger.info("userId is :{}", CacheUtil.getUserID());
        return Utils.decodeBase64(rs.getString(s));
    }

    @Override
    public String getNullableResult(ResultSet rs, int i) throws SQLException {
        logger.info("userId is :{}", CacheUtil.getUserID());
        return Utils.decodeBase64(rs.getString(i));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int i) throws SQLException {
        logger.info("userId is :{}", CacheUtil.getUserID());
        return Utils.decodeBase64(cs.getString(i));
    }
}
