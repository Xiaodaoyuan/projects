package com.xiaody.spring_boot.shiro.dao.impl;

import com.xiaody.spring_boot.shiro.dao.IRoleDao;
import com.xiaody.spring_boot.shiro.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Xiaody on 17/7/13.
 */
@Repository
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Role createRole(Role role) {
        String sql = "insert into sys_roles(role,description,available) values(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, role.getRole());
                ps.setString(2, role.getDescription());
                ps.setBoolean(3, role.getAvailable());
                return ps;
            }
        }, keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        //先把user和role关联的数据删除
        String sql = "delete from sys_users_roles where role_id=?";
        jdbcTemplate.update(sql, roleId);
        sql = "delete from sys_roles where id=?";
        jdbcTemplate.update(sql, roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0) {
            return;
        }

        String sql = "insert into sys_roles_permissions values(?,?)";
        for (Long permissionId : permissionIds) {
            if (!exists(roleId, permissionId)) {
                jdbcTemplate.update(sql, roleId, permissionId);
            }
        }
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0) {
            return;
        }

        String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
        for (Long permissionId : permissionIds) {
            if (exists(roleId, permissionId)) {
                jdbcTemplate.update(sql, roleId, permissionId);
            }
        }
    }

    private boolean exists(Long roleId, Long permissionId) {
        String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, roleId, permissionId) != 0;
    }
}
