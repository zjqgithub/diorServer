package com.yang.dior.mapper.ext;

import com.yang.dior.mapper.tpl.ChangeRecordMapper;
import com.yang.dior.model.ext.ChangeRecordExt;
import com.yang.dior.request.ChangeRecordRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-10 22:25
 *
 ***/
@Mapper
@Repository
public interface ChangeRecordExtMapper extends ChangeRecordMapper {

    List<ChangeRecordExt> selectList(ChangeRecordRequest request);

    int countList(ChangeRecordRequest request);

    List<ChangeRecordExt> selectOrderList(@Param("uid")Integer uid);
}
