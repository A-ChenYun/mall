package com.chen.mall.interceptor;

import com.chen.mall.consts.MallConst;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.exception.UserLoginException;
import com.chen.mall.pojo.User;
import com.chen.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
            log.info("preHandler");
        if(user == null){
            log.info("user=null");
            throw new UserLoginException();
        }

        return true;
    }
}
