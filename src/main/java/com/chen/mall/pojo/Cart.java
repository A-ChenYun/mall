package com.chen.mall.pojo;

import lombok.Data;

/**
 * @Author AChen
 * @Data: 2020/3/19 3:40 下午
 */
@Data
public class Cart {
    private Integer productId;
    private Integer quantity;
    private Boolean productSelected;

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
