package com.chen.mall.service.impl;

import com.chen.mall.dao.ShippingMapper;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.enums.ShippingResponseEnum;
import com.chen.mall.form.ShippingMsgForm;
import com.chen.mall.pojo.Shipping;
import com.chen.mall.service.IShippingService;
import com.chen.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author AChen
 * @Data: 2020/3/22 10:06 下午
 */
@Service
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;
    @Override
    public ResponseVo<Map<String,Integer >> addadre(Integer uid,
                                                    ShippingMsgForm shippingMsgForm
                                                   ) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(shippingMsgForm,shipping);
        int row =
                shippingMapper.insertSelectiveShipping(shipping);
        if(row == 0){
            return ResponseVo.error(ShippingResponseEnum.NEW_ADDRESS_FAIL);
        }

        Map<String,Integer > map = new HashMap();
        map.put("shippingId",shipping.getId());
        return ResponseVo.successship(map);
    }

    @Override
    public ResponseVo deletShipping(Integer shippingId, Integer uid) {

        int row = shippingMapper.deleteByShippingAndUserId(shippingId, uid);
        if(row == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.error(ResponseEnum.SUCCESS);

    }

    @Override
    public ResponseVo updateShipping(Integer uid, ShippingMsgForm shippingMsgForm) {
        return null;
    }

    @Override
    public ResponseVo<PageInfo> seleShipping(PageInfo pageInfo) {
        return null;
    }
}
