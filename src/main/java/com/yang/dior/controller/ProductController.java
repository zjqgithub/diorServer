package com.yang.dior.controller;

import com.yang.dior.core.PageBean;
import com.yang.dior.core.Result;
import com.yang.dior.core.ResultGenerator;
import com.yang.dior.model.Product;
import com.yang.dior.request.ProductRequest;
import com.yang.dior.service.ProductService;
import io.swagger.annotations.*;
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
@Api(value = "产品ctrl",tags = {"产品操作接口"})
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="ID",required=false,paramType="form"),
            @ApiImplicitParam(name="name",value="全称",required=false,paramType="form"),
            @ApiImplicitParam(name="simpleName",value="简称",required=false,paramType="form"),
            @ApiImplicitParam(name="price",value="价格",required=false,paramType="form"),
    })
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody @ApiParam(name="request",value="传入json格式(表单提交)",required=true) ProductRequest request) {
        productService.saveOrUpdate(request);
        return ResultGenerator.genSuccessResult(null);
    }

    @PostMapping("/list")
    public Result list(@RequestBody @ApiParam(name="request",value="传入json格式(表单提交)",required=true) ProductRequest request) {
        PageBean<Product> list = productService.list(request);
        return ResultGenerator.genSuccessResult(list);
    }

}
