package com.yang.dior.model.ext;

import com.yang.dior.model.Order;
import lombok.Data;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-17 16:42
 *
 ***/
@Data
public class OrderList extends Order {

    private String userName;
    private String operatorName;
    private List<ChangeRecordExt> records;

}
