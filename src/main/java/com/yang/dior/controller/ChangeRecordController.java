package com.yang.dior.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.core.PageBean;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.request.ChangeGoodsRequest;
import com.yang.dior.request.ChangeRecordRequest;
import com.yang.dior.service.ChangeGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-10 17:35
 *
 ***/
@RestController
@RequestMapping("change")
public class ChangeRecordController {

    @Autowired
    private ChangeGoodsService changeGoodsService;

    @PostMapping("goods/checkin")
    public Result login(@RequestBody ChangeGoodsRequest request) {
        JSONObject jsonObject = changeGoodsService.changeGoods(request);
        return ResultGenerator.genSuccessResult(jsonObject);
    }


    @PostMapping("user/list")
    public Result list(@RequestBody ChangeRecordRequest request) {
        PageBean<ChangeRecordExt> list = changeGoodsService.getRecordList(request);
        return ResultGenerator.genSuccessResult(list);
    }

}
