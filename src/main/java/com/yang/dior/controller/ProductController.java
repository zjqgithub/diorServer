package com.yang.dior.controller;

import com.yang.dior.core.PageBean;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.model.Product;
import com.yang.dior.request.ProductRequest;
import com.yang.dior.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-06 20:50
 *
 ***/
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ProductRequest request) {
        productService.saveOrUpdate(request);
        return ResultGenerator.genSuccessResult(null);
    }

    @PostMapping("/list")
    public Result list(@RequestBody ProductRequest request) {
        PageBean<Product> list = productService.list(request);
        return ResultGenerator.genSuccessResult(list);
    }

}
