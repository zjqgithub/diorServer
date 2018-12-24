package com.yang.dior.service.impl;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yang.dior.mapper.tpl.ShareMapMapper;
import com.yang.dior.model.ShareMap;
import com.yang.dior.model.ShareMapExample;
import com.yang.dior.request.ShareRequest;
import com.yang.dior.service.ShareMapService;
import com.yang.dior.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-13 09:45
 *
 ***/
@Service
@Slf4j
public class ShareMapServiceImpl implements ShareMapService {

    @Autowired
    private ShareMapMapper shareMapMapper;

    @Autowired
    private UserService userService;

    @Override
    public void share(ShareRequest request) {
        ShareMap shareMap =new ShareMap();
        shareMap.setShareUid(request.getShareUid());
        shareMap.setShareFromUid(request.getShareFromUid());
        shareMap.setShareToUid(request.getShareToUid());
        shareMap.setCreateTime(new Date());
        shareMap.setUpdateTime(new Date());
        shareMapMapper.insertSelective(shareMap);
    }

    @Override
    public List<JSONObject> getShareListById(Integer id) {
        List<JSONObject> lists = Lists.newArrayList();
        if (id == null || id == 0) {
            return lists;
        }
        ShareMapExample example = new ShareMapExample();
        ShareMapExample.Criteria criteria = example.or();
        criteria.andShareToUidEqualTo(id);
        List<ShareMap> shareMapList = shareMapMapper.selectByExample(example);
        shareMapList.forEach(e -> {
            JSONObject json = new JSONObject();
            json.put("id", e.getShareUid());
            json.put("name", Optional.of(userService.getById(e.getShareUid()).getName()).orElse("X"));
            json.put("shareUid", e.getShareFromUid());
            lists.add(json);
        });
        return lists;
    }

}
