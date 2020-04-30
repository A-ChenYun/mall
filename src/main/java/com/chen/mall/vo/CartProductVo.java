package com.chen.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author AChen
 * @Data: 2020/3/19 2:46 下午
 */
@Data
public class CartProductVo {
    private Integer productId;

    private BigInteger quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStock;

    private Integer productStatus;

    private BigDecimal productTotalPrice;

    private  Boolean productSelected;
}
