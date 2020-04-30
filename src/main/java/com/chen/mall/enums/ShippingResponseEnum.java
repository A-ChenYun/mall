package com.chen.mall.enums;

import lombok.Getter;

/**
 * @Author AChen
 * @Data: 2020/3/22 10:19 下午
 */
@Getter
public enum ShippingResponseEnum {
    NEW_ADDRESS_SUCCESS(0,"新建地址成功"),
    NEW_ADDRESS_FAIL(1,"新建地址失败")
    ;

    private Integer status ;
    private  String msg
            ;

    ShippingResponseEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
