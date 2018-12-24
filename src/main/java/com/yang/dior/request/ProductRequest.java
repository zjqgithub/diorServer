package com.yang.dior.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-05 19:00
 *
 ***/
@Data
public class ProductRequest extends BaseRequest{
    private Integer id;

    private String name;

    private String simpleName;

    private BigDecimal price;

    private Integer type;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
