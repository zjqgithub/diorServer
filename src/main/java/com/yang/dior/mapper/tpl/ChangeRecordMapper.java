package com.yang.dior.mapper.tpl;

import com.yang.dior.model.ChangeRecord;
import com.yang.dior.model.ChangeRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChangeRecordMapper {
    int countByExample(ChangeRecordExample example);

    int deleteByExample(ChangeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChangeRecord record);

    int insertSelective(ChangeRecord record);

    List<ChangeRecord> selectByExample(ChangeRecordExample example);

    ChangeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChangeRecord record, @Param("example") ChangeRecordExample example);

    int updateByExample(@Param("record") ChangeRecord record, @Param("example") ChangeRecordExample example);

    int updateByPrimaryKeySelective(ChangeRecord record);

    int updateByPrimaryKey(ChangeRecord record);
}