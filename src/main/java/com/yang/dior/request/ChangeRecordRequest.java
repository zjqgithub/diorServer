package com.yang.dior.request;

import lombok.Data;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-10 22:05
 *
 ***/
@Data
public class ChangeRecordRequest extends BaseRequest {

    private Integer uid;

    private String name;

    private String mobile;

}
