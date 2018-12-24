package com.yang.dior.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yang.dior.consts.ResultConsts;
import com.yang.dior.mapper.ext.ChangeRecordExtMapper;
import com.yang.dior.mapper.tpl.OrderMapper;
import com.yang.dior.model.Order;
import com.yang.dior.model.OrderExample;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.model.ext.OrderList;
import com.yang.dior.request.OrderRequest;
import com.yang.dior.service.OrderService;
import com.yang.dior.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-17 16:14
 *
 ***/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ChangeRecordExtMapper changeRecordExtMapper;

    @Override
    public void creatorOrder(Order record) {
        if (record.getCreateTime() == null) {
            record.setCreateTime(new Date());
        }
        orderMapper.insertSelective(record);
    }

    @Override
    public JSONObject getOrderList(OrderRequest request) {
        List<OrderList> lists = Lists.newArrayList();
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.or();
        criteria.andUidEqualTo(request.getUid());
        example.setOrderByClause("create_time desc");
        List<Order> orders = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(orders)) {
            orders.forEach(e -> {
                OrderList orderList = new OrderList();
                orderList.setCost(e.getCost());
                orderList.setCreateTime(e.getCreateTime());
                List<ChangeRecordExt> changeRecordExts = changeRecordExtMapper.selectOrderList(e.getUid());
                orderList.setRecords(changeRecordExts);
                lists.add(orderList);
            });
        }
        return ResultUtils.sucResult(ResultConsts.success, lists);

    }

}
