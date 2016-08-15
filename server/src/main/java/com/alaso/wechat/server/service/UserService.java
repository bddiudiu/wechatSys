package com.alaso.wechat.server.service;


import com.alaso.wechat.server.entity.Permission;
import com.alaso.wechat.server.entity.User;

import java.util.List;

/**
 * Created by adam on 11/12/15.
 */
public interface UserService {

    void saveUser(User user);

    User checkUser(String userName, String passWord);

    void updateUser(User user);

    void delUser(Integer id);

    List<User> queryUsersByDeptId(Integer deptID);

    User findByUserName(String userName);

    User findUserById(Integer userId);

    List<Permission> getPermissionsByUserName(String username);

}
