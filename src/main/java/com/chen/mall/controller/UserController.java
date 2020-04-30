package com.chen.mall.controller;

import com.chen.mall.consts.MallConst;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.form.UserRegisterForm;
import com.chen.mall.form.UserLoginForm;
import com.chen.mall.pojo.User;
import com.chen.mall.service.impl.UserServiceImpl;
import com.chen.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/user/register")
    public ResponseVo<User> register(@RequestBody UserRegisterForm userRegisterForm,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
        //log.info("username={}", user.getUsername());
        return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindingResult);
        }
         User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login (@RequestBody UserLoginForm userLoginForm,
                                  BindingResult bindingResult, HttpSession httpSession){
        if(bindingResult.hasErrors()){
            //log.info("username={}", user.getUsername());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo =
                userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        httpSession.setAttribute(MallConst.CURRENT_USER,userResponseVo.getData());
        return userResponseVo;
    }
    //获取用户信息
    @GetMapping("/user")
    public ResponseVo<User> getInfo(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(MallConst.CURRENT_USER);
        //用拦截器判断
//        if(user == null){
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        }
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo<User> logout(HttpSession httpSession){
        log.info("httpsSessionId={}",httpSession.getId());
        //拦截器判断
        httpSession.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }

}
