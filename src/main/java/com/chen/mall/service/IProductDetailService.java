package com.chen.mall.service;

import com.chen.mall.vo.ProductDetailVo;
import com.chen.mall.vo.ResponseVo;

public interface IProductDetailService {
    ResponseVo<ProductDetailVo> productDetail(Integer productId);
}
