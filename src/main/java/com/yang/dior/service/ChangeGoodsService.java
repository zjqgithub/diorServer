package com.yang.dior.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.dior.core.PageBean;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.request.ChangeGoodsRequest;
import com.yang.dior.request.ChangeRecordRequest;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-07 18:29
 *
 ***/
public interface ChangeGoodsService {

    /**
     * 货物登记
     *
     * @param request
     * @return
     */
    JSONObject changeGoods(ChangeGoodsRequest request);

    PageBean<ChangeRecordExt> getRecordList(ChangeRecordRequest request);
}
