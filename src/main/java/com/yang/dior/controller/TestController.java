package com.yang.dior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 19:50
 *
 ***/
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(){
        return "home/home";
    }

}
