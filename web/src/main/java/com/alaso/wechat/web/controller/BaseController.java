package com.alaso.wechat.web.controller;

import com.alaso.wechat.server.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by adam on 4/5/16.
 */
public class BaseController {

    /**
     * 获得客户端请求
     * @return
     */
    public HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request;
    }

    public User getUser(){
        User user = (User)getRequest().getSession().getAttribute("user");
        return user;
    }
}
