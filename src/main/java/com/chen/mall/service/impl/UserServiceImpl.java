package com.chen.mall.service.impl;

import com.chen.mall.dao.UserMapper;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.enums.RoleEnum;
import com.chen.mall.pojo.User;
import com.chen.mall.service.IUserService;
import com.chen.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Transactional
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * 注册
     * @param user
     */
    @Override
    public ResponseVo register(User user){
        user.setRole(RoleEnum.CUSTOMER.getCode());
        //用户名不重复
        Integer countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername>0){
            //throw new RuntimeException("该用户名已经存在");
            return ResponseVo.error(ResponseEnum.USER_EXIT);
        }
        //邮箱不重复
        Integer countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail>0){
            //throw new RuntimeException("该邮箱已经存在");
            return ResponseVo.error(ResponseEnum.EMAIL_EXIT);
        }
        //密码MD5加密
        user.setPassword(        DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8))
        );
        //写入账号，邮箱，密码
        int insertSelective = userMapper.insertSelective(user);
        if(insertSelective==0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return  ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null){
            return ResponseVo.error(ResponseEnum.USERNAME_PASSWORD_ERROR);
        }
        if (!user.getPassword().equalsIgnoreCase
                (DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            return ResponseVo.error(ResponseEnum.USERNAME_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }


}
