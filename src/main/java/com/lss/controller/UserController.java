package com.lss.controller;

import com.lss.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/8.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    private  ModelAndView view;


    @RequestMapping(value = "/check")
    public ModelAndView checkUser(@RequestParam(value = "name",defaultValue = "") String name){

        return null;
    }
}
