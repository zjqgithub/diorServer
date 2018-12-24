package com.yang.dior.model.ext;

import com.yang.dior.model.ChangeRecord;
import lombok.Data;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-10 22:17
 *
 ***/
@Data
public class ChangeRecordExt extends ChangeRecord {

    private String userName;

    private String mobile;

    private String productName;

}
