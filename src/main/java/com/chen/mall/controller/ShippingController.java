package com.chen.mall.controller;

import com.chen.mall.consts.MallConst;
import com.chen.mall.form.ShippingMsgForm;
import com.chen.mall.pojo.Shipping;
import com.chen.mall.pojo.User;
import com.chen.mall.service.impl.ShippingServiceImpl;
import com.chen.mall.vo.ResponseVo;
import com.chen.mall.vo.ShippingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigInteger;

/**
 * @Author AChen
 * @Data: 2020/3/23 12:14 上午
 */
@Slf4j
@RestController
public class ShippingController {
    @Autowired
    private ShippingServiceImpl shippingService;
    @PostMapping("/shippings")
    public ResponseVo sentadre(
            @Valid @RequestBody ShippingMsgForm shippingMsgForm,
            HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        Integer uid = user.getId();
        return shippingService.addadre(uid,shippingMsgForm);
    }

    @DeleteMapping( "/shippings/{shippingId}")
    public ResponseVo deletShipping(@Valid @PathVariable("shippingId") Integer shippingId,
             HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        Integer uid = user.getId();
        log.info("uid = {}",uid);
        return shippingService.deletShipping(shippingId,uid);
    }


}
