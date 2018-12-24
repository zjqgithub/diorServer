package com.yang.dior.service;

import com.yang.dior.core.PageBean;
import com.yang.dior.model.Product;
import com.yang.dior.request.ProductRequest;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-05 08:02
 *
 ***/
public interface ProductService {

    PageBean<Product> list(ProductRequest request);

    void saveOrUpdate(ProductRequest request);

    int getPriceById(Integer id);

    List<Product> getListByIds(List<Integer> ids);
}
