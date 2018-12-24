package com.yang.dior.mapper.ext;

import com.yang.dior.mapper.tpl.ProductMapper;
import com.yang.dior.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *
 * @Author zhangjiqiang
 * @Description
 * @Date 2018-12-08 11:33
 *
 ***/
@Mapper
@Repository
public interface ProductExtMapper extends ProductMapper {

    /**
     * 根据产品id查询价格
     *
     * @param ids
     * @return
     */
    List<Product> selectListByIds(@Param("ids") List<Integer> ids);
}
