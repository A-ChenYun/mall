package com.chen.mall.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1,"失败"),
    SUCCESS (0,"成功"),
    PASSWORD_ERROR (1,"密码错误"),
    USER_EXIT(2,"用户名已经存在"),
    PARAM_ERROR(3,"参数错误"),
    EMAIL_EXIT(4,"邮箱已经存在"),
    USERNAME_PASSWORD_ERROR(5,"用户名或密码错误"),
    PRODUCT_DELATE_UNEXIT(6,"该商品已下架或删除"),
    PRODUCT_NOT_EXIT(7,"该商品还没有哟"),
    NOT_HAVE_PRODUCT(8,"卖完啦还在进货"),



    NEED_LOGIN(10,"用户未登录")
    ;
    private Integer code;
    private String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    ResponseEnum(String desc) {
        this.desc = desc;
    }
    ResponseEnum(Integer code){
        this.code = code;
    }
}
