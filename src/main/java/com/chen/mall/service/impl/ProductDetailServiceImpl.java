package com.chen.mall.service.impl;

import com.chen.mall.dao.ProductMapper;
import com.chen.mall.enums.ProductEnum;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.pojo.Product;
import com.chen.mall.service.IProductDetailService;
import com.chen.mall.vo.ProductDetailVo;
import com.chen.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductDetailServiceImpl implements IProductDetailService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseVo<ProductDetailVo> productDetail(Integer productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        if (product.getStatus().equals(ProductEnum.TAKE_OFF.getCode()) ||
                product.getStatus().equals(ProductEnum.DELATE.getCode())) {
        return ResponseVo.error(ResponseEnum.PRODUCT_DELATE_UNEXIT);
        }

        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product,productDetailVo);
        return ResponseVo.success(productDetailVo) ;
    }
}
