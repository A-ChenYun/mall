package com.chen.mall.service;

import com.chen.mall.form.CartsForm;
import com.chen.mall.vo.CartVo;
import com.chen.mall.vo.ResponseVo;

import javax.xml.ws.Response;
import java.util.List;

/**
 *
 *
 * @Author AChen
 * @Data: 2020/3/19 2:51 下午
 */
public interface ICartService {
     ResponseVo<CartVo> add(Integer uid, CartsForm cartsForm);
}
