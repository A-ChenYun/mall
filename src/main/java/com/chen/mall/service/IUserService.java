package com.chen.mall.service;


import com.chen.mall.dao.UserMapper;
import com.chen.mall.pojo.User;
import com.chen.mall.vo.ResponseVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface IUserService {

    /**
     * 注册
     */
    ResponseVo<User> register(User user);
    ResponseVo<User> login(String username, String password);

    /**
     * 登录
     */




}
