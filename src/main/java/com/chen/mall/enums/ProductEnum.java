package com.chen.mall.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * 商品状态.1-在售 2-下架 3-删除
 */
@Getter
public enum ProductEnum {
    ON_SALL(1),
    TAKE_OFF(2),
    DELATE(3)
    ;
    Integer code;

    ProductEnum(Integer code) {
        this.code = code;
    }
}
