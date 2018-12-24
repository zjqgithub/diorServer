package com.yang.dior.request;

import lombok.Data;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-11 22:55
 *
 ***/
@Data
public class UserRequest extends BaseRequest {

    private String name;
    private String mobile;
}
