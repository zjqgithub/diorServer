package com.yang.dior.mapper.tpl;

import com.yang.dior.model.ShareMap;
import com.yang.dior.model.ShareMapExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShareMapMapper {
    int countByExample(ShareMapExample example);

    int deleteByExample(ShareMapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareMap record);

    int insertSelective(ShareMap record);

    List<ShareMap> selectByExample(ShareMapExample example);

    ShareMap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareMap record, @Param("example") ShareMapExample example);

    int updateByExample(@Param("record") ShareMap record, @Param("example") ShareMapExample example);

    int updateByPrimaryKeySelective(ShareMap record);

    int updateByPrimaryKey(ShareMap record);
}