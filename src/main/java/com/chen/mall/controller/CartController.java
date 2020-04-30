package com.chen.mall.controller;

import com.chen.mall.form.CartsForm;
import com.chen.mall.service.impl.CartServiceImpl;
import com.chen.mall.vo.CartVo;
import com.chen.mall.vo.ResponseVo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author AChen
 * @Data: 2020/3/19 7:10 下午
 */
@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@RequestBody CartsForm cartsForm) {

        return null;
    }
}
