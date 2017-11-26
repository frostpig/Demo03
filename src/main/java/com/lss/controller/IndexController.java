package com.lss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frostpig on 2017/11/26.
 */
@Controller
//@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String Index(){
        return "index";
    }
}
