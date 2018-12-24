package com.yang.dior.core;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.consts.ResultConsts;

/***
 *
 * @Author zhangjiqiang
 * @Description 响应结果生成工具
 * @Date 2018/11/21 19:40
 *
 ***/
public class ResultGenerator {

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(ResultConsts.success);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(ResultConsts.success)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genJSONResult(JSONObject obj) {
        return new Result()
                .setCode(obj.getBoolean(ResultConsts.result) ? ResultCode.SUCCESS : ResultCode.FAIL)
                .setMessage(obj.getString(ResultConsts.msg))
                .setData(obj);
    }
}
