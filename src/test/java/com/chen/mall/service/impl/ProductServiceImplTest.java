package com.chen.mall.service.impl;

import com.chen.mall.MallApplicationTests;
import com.chen.mall.vo.ProductVo;
import com.chen.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
@Slf4j
public class ProductServiceImplTest extends MallApplicationTests {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void list() {
        ResponseVo<PageInfo> list = productService.list(null, 1, 3);
        log.info("list = {}", list);
    }
}