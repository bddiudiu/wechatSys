package com.alaso.wechat.server.service.impl;

import com.alaso.wechat.server.dao.UserMapper;
import com.alaso.wechat.server.entity.Permission;
import com.alaso.wechat.server.entity.User;
import com.alaso.wechat.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adam on 11/12/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public User checkUser(String userName, String passWord) {
        return userMapper.checkUser(userName,passWord);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void delUser(Integer id) {
        userMapper.delUser(id);
    }

    public List<User> queryUsersByDeptId(Integer deptID) {
        return userMapper.queryUsersByDeptId(deptID);
    }

    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    public User findUserById(Integer userId){
        return userMapper.findUserById(userId);
    }

    public List<Permission> getPermissionsByUserName(String username) {
        return userMapper.getPermissionsByUserName(username);
    }
}
