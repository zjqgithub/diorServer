package com.yang.dior.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.request.OrderRequest;
import com.yang.dior.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-17 18:15
 *
 ***/
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/list")
    public Result list(@RequestBody OrderRequest request) {
        JSONObject orderList = orderService.getOrderList(request);
        return ResultGenerator.genSuccessResult(orderList);
    }

    @PostMapping("/save")
    public Result save(@RequestBody OrderRequest request) {

        return ResultGenerator.genSuccessResult(null);
    }
}
