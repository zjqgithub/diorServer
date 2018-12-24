package com.yang.dior.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.request.ShareRequest;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-13 09:45
 *
 ***/
public interface ShareMapService {

    /**
     * 分享用户
     * @param request
     */
    void share(ShareRequest request);

    List<JSONObject> getShareListById(Integer id);
}
