package com.chen.mall.service;

import com.chen.mall.form.ShippingMsgForm;
import com.chen.mall.pojo.Shipping;
import com.chen.mall.vo.ResponseVo;
import com.chen.mall.vo.ShippingVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.Map;

/**
 * @Author AChen
 * @Data: 2020/3/22 9:57 下午
 */
public interface IShippingService {
    ResponseVo<Map<String ,Integer >> addadre(Integer uid,
                                              ShippingMsgForm shippingMsgForm
                                              );

    ResponseVo deletShipping( Integer shippingId, Integer userId);

    ResponseVo updateShipping(Integer uid, ShippingMsgForm shippingMsgForm);

    ResponseVo<PageInfo> seleShipping(PageInfo pageInfo);
}
