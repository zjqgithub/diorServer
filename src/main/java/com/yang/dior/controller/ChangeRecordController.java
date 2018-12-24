package com.yang.dior.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.core.PageBean;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.request.ChangeGoodsRequest;
import com.yang.dior.request.ChangeRecordRequest;
import com.yang.dior.service.ChangeGoodsService;
import io.swagger.annotations.*;
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
@Api(value = "控制中心ctrl",tags = {"货物登记，分享用户操作接口"})
@RestController
@RequestMapping("change")
public class ChangeRecordController {

    @Autowired
    private ChangeGoodsService changeGoodsService;

    @ApiOperation(value = "货物登记")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lists",value="参数数组，里面是数组的元素属性",required=true,paramType="form"),
    })
    @PostMapping("goods/checkin")
    public Result login(@RequestBody @ApiParam(name="request",value="传入json格式(表单提交)",required=true) ChangeGoodsRequest request) {
        JSONObject jsonObject = changeGoodsService.changeGoods(request);
        return ResultGenerator.genSuccessResult(jsonObject);
    }


    @PostMapping("user/list")
    public Result list(@RequestBody @ApiParam(name="request",value="传入json格式(表单提交)",required=true) ChangeRecordRequest request) {
        PageBean<ChangeRecordExt> list = changeGoodsService.getRecordList(request);
        return ResultGenerator.genSuccessResult(list);
    }

}
