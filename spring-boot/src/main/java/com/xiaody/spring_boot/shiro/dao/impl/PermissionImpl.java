package com.xiaody.spring_boot.shiro.dao.impl;

import com.xiaody.spring_boot.shiro.entity.Permission;
import com.xiaody.spring_boot.shiro.dao.IPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Xiaody on 17/7/13.
 */
@Repository
public class PermissionImpl implements IPermissionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Permission createPermission(Permission permission) {
        String sql = "insert into sys_permissions(permission,description,available) values(?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, permission.getPermission());
                ps.setString(2, permission.getDescription());
                ps.setBoolean(3, permission.getAvailable());
                return ps;
            }
        }, keyHolder);
        permission.setId(keyHolder.getKey().longValue());
        return permission;
    }

    @Override
    public void deletePermission(Long permissionId) {
        //先把role和permission关联的数据删除
        String sql = "delete from sys_roles_permissions where permission_id=?";
        jdbcTemplate.update(sql, permissionId);
        sql = "delete from sys_permissions where id=?";
        jdbcTemplate.update(sql, permissionId);
    }
}
