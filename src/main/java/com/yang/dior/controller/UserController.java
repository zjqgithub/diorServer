package com.yang.dior.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yang.dior.consts.ResultConsts;
import com.yang.dior.core.PageBean;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.model.UserInfo;
import com.yang.dior.request.AddUserRequest;
import com.yang.dior.request.UserRequest;
import com.yang.dior.service.ShareMapService;
import com.yang.dior.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 18:13
 *
 ***/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShareMapService shareMapService;


    @PostMapping("/register")
    public Result register(@RequestBody AddUserRequest request) {
        JSONObject register = userService.register(request);
        return ResultGenerator.genJSONResult(register);
    }

    @PostMapping("/login")
    public Result login(@RequestBody AddUserRequest request) {
        JSONObject login = userService.login(request);
        List<JSONObject> lists = Lists.newArrayList();
        JSONObject resultData = new JSONObject();
        if (login.getBooleanValue(ResultConsts.result)) {
            int id = login.getIntValue(ResultConsts.data);
            // 自己创建的用户
            List<JSONObject> childrenList = userService.getChildrenById(id);
            // 别人分享的用户
            List<JSONObject> shareList = shareMapService.getShareListById(id);
            lists.addAll(childrenList);
            lists.addAll(shareList);
            resultData.put("uid", id);
            resultData.put("lists", lists);
        }
        login.put(ResultConsts.data, resultData);
        return ResultGenerator.genSuccessResult(login);
    }

    @PostMapping("/logout")
    public Result logout() {
        return ResultGenerator.genSuccessResult(null);
    }


    @GetMapping("/info")
    public JSONObject info() {
        JSONObject info = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("roles", Lists.newArrayList("admin"));
        data.put("avatar", "http://www.hongkonganran.com/pic/gif/1440820472.jpg");
        info.put("name", "zz");
        info.put("code", 0);
        info.put("data", data);
        return info;
    }


//    @PostMapping("/login")
//    public JSONObject login(String username,String password){
//        JSONObject info = new JSONObject();
//        JSONObject data = new JSONObject();
//        data.put("token","xxxxtokenxxxx");
//        info.put("code",0);
//        info.put("data",data);
//        return info;
//    }

    @PostMapping("/list")
    public Result list(@RequestBody @ApiParam(name = "request", value = "传入json格式(表单提交)", required = true) UserRequest request) {
        PageBean<UserInfo> list = userService.list(request);
        return ResultGenerator.genSuccessResult(list);
    }

}
