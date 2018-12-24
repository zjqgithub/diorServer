package com.yang.dior.request;

import com.yang.dior.model.ChangeRecord;
import lombok.Data;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-07 18:31
 *
 ***/
@Data
public class ChangeGoodsRequest extends BaseRequest{

    private List<ChangeRecord> lists;

    private Integer uid;

    private Integer operator;

    private Integer cost;

}
