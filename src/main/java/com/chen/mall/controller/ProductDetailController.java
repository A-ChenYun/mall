package com.chen.mall.controller;

import com.chen.mall.service.impl.ProductDetailServiceImpl;
import com.chen.mall.vo.ProductDetailVo;
import com.chen.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailController {
    @Autowired
    private ProductDetailServiceImpl productDetailService;

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> productDetail(@PathVariable Integer productId){
        return productDetailService.productDetail(productId);
    }
}
