package com.yang.dior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-15 23:41
 *
 ***/
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String index(){
        return "admin";
    }
}
