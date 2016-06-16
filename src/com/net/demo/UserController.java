package com.net.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @包名 com.net.demo.UserController
 * @类名 UserController
 * @作者 snail
 * @创建时间 2015-4-28
 * @描述 TODO
 */
@Controller
public class UserController {

    @Autowired
    public UserDao userDao;

    /**
     * @方法名 getUserList
     * @方法描述 获取所有用户列表
     * @返回类型 String 
     * @创建日期 2015-10-21
     */
    @RequestMapping("UserList")
    public String getUserList(Model model) {
        model.addAttribute("userList", userDao.getAllUsers());
        return "success.jsp";
    }
}
