package com.chen.mall.form;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * 添加商品表单
 * @Author AChen
 * @Data: 2020/3/19 2:35 下午
 */
@Data
public class CartsForm {
    @NotNull
    private Integer productId;
    private Boolean selected = true;
}
