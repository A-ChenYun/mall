package com.chen.mall.controller;

import com.chen.mall.service.impl.Md5AllIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Md5Controller {
    @Autowired
    private Md5AllIServiceImpl md5AllIServiceImplAll;

    @GetMapping("/md5all")
    public String md5all() throws IOException {
        String md5AllC = md5AllIServiceImplAll.md5All();
        return md5AllC;
    }

}
