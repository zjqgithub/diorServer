package com.yang.dior.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.model.Order;
import com.yang.dior.request.OrderRequest;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-17 16:15
 *
 ***/
public interface OrderService {

    void creatorOrder(Order record);

    JSONObject getOrderList(OrderRequest request);
}
