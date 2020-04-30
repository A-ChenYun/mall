package com.chen.mall.service.impl;

import com.chen.mall.MallApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findSubCategoryId() {
        Set<Integer> result = new HashSet<>();
        categoryService.findSubCategoryId(100001, result);
        log.info("findSubCategoryId = {}",result);


    }
}