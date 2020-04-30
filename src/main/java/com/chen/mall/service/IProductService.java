package com.chen.mall.service;

import com.chen.mall.pojo.Product;
import com.chen.mall.vo.ProductVo;
import com.chen.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IProductService {
    ResponseVo<PageInfo>  list(Integer  categoryId, Integer pageNum, Integer pageSize);
}
