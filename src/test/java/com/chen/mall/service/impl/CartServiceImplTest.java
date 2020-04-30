package com.chen.mall.service.impl;

import com.chen.mall.MallApplicationTests;
import com.chen.mall.form.CartsForm;
import com.chen.mall.service.ICartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author AChen
 * @Data: 2020/3/19 3:58 下午
 */
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void add() {
        CartsForm form = new CartsForm();
        form.setProductId(27);
        form.setSelected(true);
        cartService.add(1, form);
    }
}