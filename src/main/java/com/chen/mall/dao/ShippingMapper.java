package com.chen.mall.dao;

import com.chen.mall.form.ShippingMsgForm;
import com.chen.mall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int insertSelectiveShipping(Shipping record);

    int deleteByShippingAndUserId(@Param("shippingId") Integer shippingId,
            @Param("uid")Integer uid);

}