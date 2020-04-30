package com.chen.mall.service.impl;

import com.chen.mall.MallApplicationTests;
import com.chen.mall.form.ShippingMsgForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author AChen
 * @Data: 2020/3/23 12:33 下午
 */
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private ShippingServiceImpl shippingService;
    @Test
    public void addadre() {
        Integer uid = 1;
        ShippingMsgForm shippingMsgForm = new ShippingMsgForm();
        shippingMsgForm.setReceiverName("ouyang");
        shippingMsgForm.setReceiverPhone("1232311");
        shippingMsgForm.setReceiverMobile("121321");
        shippingMsgForm.setReceiverProvince("湖北");
        shippingMsgForm.setReceiverCity("enshi");
        shippingMsgForm.setReceiverAddress("sasas");
        shippingMsgForm.setReceiverZip("1221");
        shippingService.addadre(uid,shippingMsgForm);


    }
}