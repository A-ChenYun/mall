package com.chen.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author AChen
 * @Data: 2020/3/19 2:44 下午
 */
@Data
public class CartVo {
    private List<CartProductVo> cartProductVoLis;

    private Boolean selectAll;

    private BigDecimal cartTotalPrice;

    private BigInteger cartTotalQuantity;
}
