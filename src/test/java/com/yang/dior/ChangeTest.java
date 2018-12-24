package com.yang.dior;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import com.yang.dior.model.ChangeRecord;
import com.yang.dior.request.ChangeGoodsRequest;
import com.yang.dior.service.ChangeGoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-08 19:44
 *
 ***/
public class ChangeTest extends DiorApplicationTests {

    @Autowired
    private ChangeGoodsService changeGoodsService;

    @Test
    public void change() {
        ChangeGoodsRequest request=new ChangeGoodsRequest();
        request.setLists(Lists.newArrayList());
        List<ChangeRecord> lists = Lists.newArrayList();
        ChangeRecord record = new ChangeRecord();
        record.setUid(1);
        record.setPid(1);
        record.setNum(1);
        lists.add(record);
        request.setLists(lists);
        JSONObject jsonObject = changeGoodsService.changeGoods(request);
        System.out.println(jsonObject.toJSONString());

    }
}
