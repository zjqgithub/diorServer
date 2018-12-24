package com.yang.dior.request;

import lombok.Data;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-13 19:49
 *
 ***/
@Data
public class ShareRequest extends BaseRequest{

    private Integer shareUid;

    private Integer shareFromUid;

    private Integer shareToUid;

}
