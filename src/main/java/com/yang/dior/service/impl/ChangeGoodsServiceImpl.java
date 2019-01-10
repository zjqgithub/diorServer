package com.yang.dior.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yang.dior.core.PageBean;
import com.yang.dior.mapper.ext.ChangeRecordExtMapper;
import com.yang.dior.model.ChangeRecord;
import com.yang.dior.model.Order;
import com.yang.dior.model.UserInfo;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.request.ChangeGoodsRequest;
import com.yang.dior.request.ChangeRecordRequest;
import com.yang.dior.service.ChangeGoodsService;
import com.yang.dior.service.OrderService;
import com.yang.dior.service.ProductService;
import com.yang.dior.service.UserService;
import com.yang.dior.utils.OrderCodeFactory;
import com.yang.dior.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-07 18:28
 *
 ***/
@Service
@Slf4j
public class ChangeGoodsServiceImpl implements ChangeGoodsService {

    @Autowired
    private ChangeRecordExtMapper changeRecordMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    private void saveRecord(ChangeRecord record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        changeRecordMapper.insertSelective(record);
    }

    @Override
    public PageBean<ChangeRecordExt> getRecordList(ChangeRecordRequest request) {
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<ChangeRecordExt> list = changeRecordMapper.selectList(request);
        int countList = changeRecordMapper.countList(request);
        PageBean<ChangeRecordExt> pageData = new PageBean<>(request.getPage(), request.getLimit(), countList);
        pageData.setItems(list);
        return pageData;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JSONObject changeGoods(ChangeGoodsRequest request) {
        List<ChangeRecord> lists = request.getLists();
        if (CollectionUtils.isEmpty(lists)) {
            return ResultUtils.failResult("没有添加任何东西哦~");
        }
        lists.forEach(r->r.setCost(computeTotal(r)));
        int sum = lists.stream().mapToInt(r -> r.getCost()).sum();
        request.setCost(sum);
        if (request.getUid() == null || request.getOperator() == null || request.getCost() == 0) {
            return ResultUtils.failResult("检查一下哪里不对哦~");
        }
        String orderCode = OrderCodeFactory.getOrderCode(request.getUid().toString());
        UserInfo userInfo = userService.getById(request.getUid());
        if (userInfo == null) {
            return ResultUtils.failResult("用户不存在");
        }
        // 创建订单
        Order order = new Order();
        order.setId(orderCode);
        order.setUid(request.getUid());
        order.setOperator(request.getOperator());
        order.setBalancePre(userInfo.getBalance());
        order.setCost(request.getCost());
        order.setBalanceAfter(userInfo.getBalance() - request.getCost());
        order.setCreateTime(new Date());
        orderService.creatorOrder(order);
        // 插入记录
        lists.forEach(e -> {
            e.setOrderid(orderCode);
            saveRecord(e);
        });
        // 更新用户余额
        UserInfo user = new UserInfo();
        user.setId(request.getUid());
        user.setBalance(userInfo.getBalance() - request.getCost());
        userService.updateUser(user);
        return ResultUtils.sucResult("success");
    }

    private int computeTotal(ChangeRecord record) {
        return productService.getPriceById(record.getPid()) * record.getNum();
    }
}
