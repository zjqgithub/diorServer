package com.yang.dior.service.impl;

import com.github.pagehelper.PageHelper;
import com.yang.dior.core.PageBean;
import com.yang.dior.mapper.ext.ProductExtMapper;
import com.yang.dior.model.Product;
import com.yang.dior.model.ProductExample;
import com.yang.dior.request.ProductRequest;
import com.yang.dior.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-05 08:02
 *
 ***/
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductExtMapper productMapper;

    @Override
    public PageBean<Product> list(ProductRequest request) {
        PageHelper.startPage(request.getPage(), request.getLimit());
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.or();
        if (StringUtils.isNotBlank(request.getName())) {
            criteria.andNameLike("%" + request.getName() + "%");
        }
        if (request.getType() != null) {
            criteria.andTypeEqualTo(request.getType());
        }
        productExample.setOrderByClause("id desc");
        List<Product> products = productMapper.selectByExample(productExample);
        int count = productMapper.countByExample(productExample);
        PageBean<Product> pageData = new PageBean<>(request.getPage(), request.getLimit(), count);
        pageData.setItems(products);
        return pageData;
    }

    @Override
    public void saveOrUpdate(ProductRequest request) {
        if (request == null) {
            return;
        }
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        product.setUpdateTime(new Date());
        if (product.getId() != null && product.getId() != 0) {
            productMapper.updateByPrimaryKeySelective(product);
        } else {
            product.setCreateTime(new Date());
            productMapper.insertSelective(product);
        }

    }

    @Override
    public int getPriceById(Integer id) {
        Assert.isTrue(id != null && id != 0, "产品id不能为空");
        Product product = productMapper.selectByPrimaryKey(id);
        Assert.notNull(product, "产品不存在");
        return product.getPrice().intValue();
    }

    @Override
    public List<Product> getListByIds(List<Integer> ids) {
        Assert.isTrue(!CollectionUtils.isEmpty(ids), "产品清单不能为空呦~");
        return productMapper.selectListByIds(ids);
    }

}
