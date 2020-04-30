package com.chen.mall.controller;

import com.chen.mall.service.impl.CategoryServiceImpl;
import com.chen.mall.vo.CategoryVo;
import com.chen.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll(){
        ResponseVo<List<CategoryVo>> listResponseVo = categoryService.selectAll();
        return listResponseVo;
    }


}
