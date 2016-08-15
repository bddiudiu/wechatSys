package com.alaso.wechat.web.shiro;

import com.alaso.wechat.server.entity.Permission;
import com.alaso.wechat.server.entity.User;
import com.alaso.wechat.server.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adam on 10/1/16.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = String.valueOf(usernamePasswordToken.getUsername());
        User user = userService.findByUserName(username);
        AuthenticationInfo authenticationInfo = null;
        if (null != user) {
            String password = new String(usernamePasswordToken.getPassword());
            if (password.equals(user.getPassword())) {
                authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
            }
        }
        return authenticationInfo;
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if (username != null) {
            List<Permission> permissionList = userService.getPermissionsByUserName(username);
            if (permissionList != null && !permissionList.isEmpty()) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                for (Permission permission : permissionList) {
                    //将权限资源添加到用户信息中
                    info.addStringPermission(permission.getUrl());
                }
                return info;
            }
        }
        return null;
    }
}
