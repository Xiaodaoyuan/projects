package com.xiaody.spring_boot.shiro.dao;

import com.xiaody.spring_boot.shiro.entity.Permission;

/**
 * Created by Xiaody on 17/7/13.
 */
public interface IPermissionDao {
     Permission createPermission(Permission permission);

     void deletePermission(Long permissionId);
}
