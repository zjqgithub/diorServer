package com.yang.dior.request;

import lombok.Data;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018/11/21 18:15
 *
 ***/
@Data
public class AddUserRequest extends BaseRequest {

    private String name;

    private String mobile;

    private String anran_name;

    private String pwd;

    private Integer creator_id;

}
