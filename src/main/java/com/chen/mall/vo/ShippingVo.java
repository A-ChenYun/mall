package com.chen.mall.vo;

import lombok.Data;

/**
 * @Author AChen
 * @Data: 2020/3/22 9:51 下午
 */
@Data
public class ShippingVo {
    private String receiverName;

    private String receiverPhone;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;
}
