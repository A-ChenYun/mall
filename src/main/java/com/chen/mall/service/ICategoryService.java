package com.chen.mall.service;

import com.chen.mall.vo.CategoryVo;
import com.chen.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    /**
     *
     * 查询所有信息
     */
    ResponseVo<List<CategoryVo>> selectAll();

   void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
