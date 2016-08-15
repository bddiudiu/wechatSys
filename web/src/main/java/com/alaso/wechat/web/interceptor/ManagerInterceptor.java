package com.alaso.wechat.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by adam on 7/5/16.
 */
public class ManagerInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(ManagerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("===========进入过滤器=========");
        logger.info("===========request=========" + request);
        logger.info("===========进入过滤器=========" + request.getRequestURI());
        logger.info("===========进入过滤器=========" + request.getSession());
        logger.info("===========进入过滤器=========" + request.getSession().getAttributeNames());

        Enumeration enumeration=request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()){
            logger.info("===========进入过滤器  内容=========" + enumeration.nextElement().toString());
        }

        request.setCharacterEncoding("UTF-8");

        if (request.getSession().getAttribute("user") != null) {
            logger.info("用户已登录,完成验证");
            return true;
        } else {
            logger.info("用户未登录,跳转首页");
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
