package com.chen.mall.service.impl;

import com.chen.mall.dao.CategoryMapper;
import com.chen.mall.pojo.Category;
import com.chen.mall.service.IMd5Service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/*对数据库整体MD5加密，该部分内容不涉及该项目任何操作，可删除*/
@Transactional
@Slf4j
@Service
public class Md5AllIServiceImpl implements IMd5Service {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public String md5All() throws IOException {
        List<Category> categories = categoryMapper.selectAll();
        List categoryList = new ArrayList();
        for (Category category : categories) {
            categoryList.add(category);
        }
        log.info("======================================");
        log.info("categoryList = {}", categoryList);
        log.info("======================================");

        String list_str = listToJson(categoryList);
        log.info("++++++++++++++++++++++++++++++++++++++");
        log.info("categoryList = {}", list_str);
        log.info("++++++++++++++++++++++++++++++++++++++");
        //SHA_256 https://www.baeldung.com/sha-256-hashing-java
        String allString = DigestUtils.md5DigestAsHex(list_str.getBytes(StandardCharsets.UTF_8));
        return allString;
    }

    public static <Category> String listToJson(List<Category> categoryList) {
        String jsons = JSON.toJSONString(categoryList);
        return jsons;
    }
}
