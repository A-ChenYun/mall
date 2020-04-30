package com.chen.mall.service.impl;

import com.chen.mall.dao.ProductMapper;
import com.chen.mall.pojo.Product;
import com.chen.mall.service.IProductService;
import com.chen.mall.vo.ProductVo;
import com.chen.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseVo<PageInfo> list(Integer  categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        //根据categoryIdSet查数据在productMapper中

        if (categoryIdSet != null){
        categoryService.findSubCategoryId(categoryId, categoryIdSet);
        categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = products.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo<>(products);
        pageInfo.setList(products);
/*
        log.info("productVoList = {}", productVoList);
*/
        return ResponseVo.success(pageInfo);
    }
}
