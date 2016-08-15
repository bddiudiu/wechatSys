package com.alaso.wechat.server.dao;


import com.alaso.wechat.server.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限
 * Created by adam on 13/1/16.
 */
@Repository("permissionMapper")
public interface PermissionMapper {

    List<Permission> queryPermissions();

    void addPermissions(@Param("permissions") Permission permission);

    void updatePermissions(@Param("permissions") Permission permission);

    void delPermissions(@Param("ids") String... ids);

    List<Permission> queryPermissionsByParam(@Param("col") String col,@Param("val") String val);
}
