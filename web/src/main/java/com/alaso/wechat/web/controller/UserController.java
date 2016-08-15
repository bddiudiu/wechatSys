package com.alaso.wechat.web.controller;

import com.alaso.wechat.server.entity.User;
import com.alaso.wechat.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by adam on 14/6/16.
 */
@Controller
@RequestMapping("/user/**")
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("queryUsersPage")
    public ModelAndView queryUsersPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backSys/users/userList");
        return modelAndView;
    }

    @RequestMapping("queryUsers")
    @ResponseBody
    public List<User> queryUsers(){
        logger.debug("获取用户信息数据");
        List<User> userList = userService.queryUsersByDeptId(1);
        return userList;
    }

    @RequestMapping("modifyUserPage")
    public ModelAndView modifyUserPage(@RequestParam(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backSys/users/modifyUser");
        User user = new User();
        try {
            user = userService.findUserById(id);
            logger.debug("开始编辑用户{}信息,用户的ID为{}",new Object[]{user.getUserName(),user.getId()});
            modelAndView.addObject("user",user);
        }catch (Exception e){
            logger.error("获取ID为{}的用户信息时发生错误{}",new Object[]{id,e.getMessage()});
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("modifyUser")
    @ResponseBody
    public boolean modifyUser(@RequestBody() User user){
        logger.debug("开始更新用户{}的个人信息", new Object[]{user.getUserName()});
        boolean flag = false;
        try {
            userService.updateUser(user);
            flag = true;
        }catch (Exception e){
            logger.error("更新用户{}的个人信息时发生错误{}", new Object[]{user.getUserName(),e.getMessage()});
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping("addUserPage")
    public ModelAndView addUserPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backSys/users/addUser");
        //将用户的组织机构ID传递出去?
        return modelAndView;
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public boolean saveUser(@RequestBody() User user){
        logger.debug("开始新增用户{}的个人信息", new Object[]{user.getUserName()});
        boolean flag = true;
        try {
            userService.saveUser(user);
        } catch (Exception e){
            flag = false;
            logger.error("新增用户{}的个人信息时发生错误{}", new Object[]{user.getUserName(),e.getMessage()});
            e.printStackTrace();
        }
        return flag;
    }

}
