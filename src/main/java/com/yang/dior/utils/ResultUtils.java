package com.yang.dior.utils;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.consts.ResultConsts;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 18:30
 *
 ***/
public class ResultUtils {

    public static JSONObject sucResult(String msg) {
        JSONObject result = new JSONObject();
        result.put(ResultConsts.result, true);
        result.put(ResultConsts.msg, msg);
        return result;
    }

    public static JSONObject sucResult(String msg,Object data) {
        JSONObject result = new JSONObject();
        result.put(ResultConsts.result, true);
        result.put(ResultConsts.msg, msg);
        result.put(ResultConsts.data, data);
        return result;
    }

    public static JSONObject failResult(String msg) {
        JSONObject result = new JSONObject();
        result.put(ResultConsts.result, false);
        result.put(ResultConsts.msg, msg);
        return result;
    }

}
