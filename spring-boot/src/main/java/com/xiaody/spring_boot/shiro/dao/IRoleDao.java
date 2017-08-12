package com.xiaody.spring_boot.shiro.dao;

import com.xiaody.spring_boot.shiro.entity.Role;

/**
 * Created by Xiaody on 17/7/13.
 */
public interface IRoleDao {
     Role createRole(Role role);
     void deleteRole(Long roleId);

     void correlationPermissions(Long roleId, Long... permissionIds);
     void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
