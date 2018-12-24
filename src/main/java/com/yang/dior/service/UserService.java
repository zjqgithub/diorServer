package com.yang.dior.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.core.PageBean;
import com.yang.dior.model.UserInfo;
import com.yang.dior.request.AddUserRequest;
import com.yang.dior.request.UserRequest;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 18:18
 *
 ***/
public interface UserService {

    /**
     * 注册
     * @param request
     * @return
     */
    JSONObject register(AddUserRequest request);

    /**
     * 登录
     * @param request
     * @return
     */
    JSONObject login(AddUserRequest request);

    UserInfo getById(Integer id);

    void updateUser(UserInfo userInfo);

    PageBean<UserInfo> list(UserRequest request);

    List<JSONObject> getChildrenById(Integer id);
}
