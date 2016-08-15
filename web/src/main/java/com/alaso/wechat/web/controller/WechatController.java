package com.alaso.wechat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adam on 5/8/16.
 */

@Controller
@RequestMapping(value = "/wechat/**")
public class WechatController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WechatController.class);

    @RequestMapping("initWechatPage")
    public ModelAndView initWechatPage(){
        logger.debug("{}用户开始进行微信初始化操作!",new Object[]{getUser().getUserName()});
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backSys/wechat/wechat");
        return modelAndView;
    }

    @RequestMapping("initWechat")
    public boolean initWechat(){
        boolean flag = false;
        //保存微信公众号信息
        return flag;
    }


    /**
     * 微信的消息逻辑
     * 尝试使用观察者模式 进行消息的自动推送
     */

}
