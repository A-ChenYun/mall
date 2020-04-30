package com.chen.mall.service.impl;

import com.chen.mall.MallApplicationTests;
import com.chen.mall.enums.RoleEnum;
import com.chen.mall.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImplTest extends MallApplicationTests {
                                                                                     
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void register() {
        User user = new User("kekek","qwqqqw","qwqwq@asa", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}