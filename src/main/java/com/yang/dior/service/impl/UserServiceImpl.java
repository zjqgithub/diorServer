package com.yang.dior.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.yang.dior.core.PageBean;
import com.yang.dior.mapper.tpl.UserInfoMapper;
import com.yang.dior.model.UserInfo;
import com.yang.dior.model.UserInfoExample;
import com.yang.dior.request.AddUserRequest;
import com.yang.dior.request.UserRequest;
import com.yang.dior.service.UserService;
import com.yang.dior.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 18:18
 *
 ***/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userMapper;

    @Override
    public JSONObject register(AddUserRequest request) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.or();
        criteria.andMobileEqualTo(request.getMobile());
        int i = userMapper.countByExample(example);
        if (i > 0) {
            return ResultUtils.failResult("手机号已注册");
        }
        UserInfo record = new UserInfo();
        record.setMobile(request.getMobile());
        record.setPwd(request.getPwd());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreatorId(request.getCreator_id());
        int insert = userMapper.insertSelective(record);
        if (insert > 0) {
            return ResultUtils.sucResult("注册成功");
        } else {
            return ResultUtils.failResult("注册失败");
        }

    }

    @Override
    public JSONObject login(AddUserRequest request) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.or();
        criteria.andMobileEqualTo(request.getMobile());
        List<UserInfo> userInfos = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userInfos)) {
            return ResultUtils.failResult("账号或密码错误");
        }
        if (userInfos.size() == 1) {
            if (Objects.equals(userInfos.get(0).getPwd(), request.getPwd())) {
                return ResultUtils.sucResult("登陆成功", userInfos.get(0).getId());
            } else {
                return ResultUtils.failResult("账号或密码错误");
            }
        } else {
            return ResultUtils.failResult("登录出错，可能是服务器睡着了");
        }
    }

    @Override
    public UserInfo getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        Assert.isTrue(userInfo != null, "用户不能为空");
        Assert.isTrue(userInfo.getId() != null && userInfo.getId() != 0, "用户id不能为空");
        userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public PageBean<UserInfo> list(UserRequest request) {
        PageHelper.startPage(request.getPage(), request.getLimit());
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.or();
        if (StringUtils.isNotBlank(request.getName())) {
            criteria.andNameLike("%" + request.getName() + "%");
        }
        if (StringUtils.isNotBlank(request.getMobile())) {
            criteria.andMobileLike("%" + request.getMobile() + "%");
        }
        userInfoExample.setOrderByClause("id desc");
        List<UserInfo> userInfos = userMapper.selectByExample(userInfoExample);
        int count = userMapper.countByExample(userInfoExample);
        PageBean<UserInfo> pageData = new PageBean<>(request.getPage(), request.getLimit(), count);
        userInfos.forEach(u -> u.setCreator(getNameById(u.getCreatorId())));
        pageData.setItems(userInfos);
        return pageData;
    }

    private String getNameById(Integer id) {
        UserInfo userInfo = userMapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            return "system";
        } else {
            return userInfo.getName();
        }
    }

    @Override
    public List<JSONObject> getChildrenById(Integer id) {
        List<JSONObject> lists = Lists.newArrayList();
        if (id == null || id == 0) {
            return lists;
        }
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.or();
        criteria.andCreatorIdEqualTo(id);
        List<UserInfo> infos = userMapper.selectByExample(example);
        infos.forEach(e -> {
            JSONObject json = new JSONObject();
            json.put("id", e.getId());
            json.put("name", e.getName());
            json.put("shareUid", id);
            lists.add(json);
        });
        return lists;
    }

}
