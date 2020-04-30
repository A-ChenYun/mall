package com.chen.mall.dao;

import com.chen.mall.pojo.Product;
import com.chen.mall.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ProductMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByCategoryIdSet( @Param("categoryIdSet") Set<Integer> categoryIdSet);

}