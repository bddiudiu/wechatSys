package com.alaso.wechat.server.dao;

import com.alaso.wechat.server.entity.Permission;
import com.alaso.wechat.server.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adam on 11/12/15.
 */
@Repository("userMapper")
public interface UserMapper {

    void saveUser(@Param("user") User user);

    User checkUser(@Param("userName") String userName, @Param("password") String passWord);

    void updateUser(@Param("user") User user);

    void delUser(@Param("id") Integer id);

    List<User> queryUsersByDeptId(@Param("deptId") Integer deptID);

    User findByUserName(@Param("userName") String userName);

    User findUserById(@Param("id") Integer userId);

    List<Permission> getPermissionsByUserName(@Param("username") String username);

    List<Permission> getAllPermissionsByUserName();
}
