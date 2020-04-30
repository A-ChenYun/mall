package com.chen.mall.vo;

import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.enums.ShippingResponseEnum;
import com.chen.mall.pojo.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class ResponseVo<T> {
    private Integer status;
    private String msg;
    private T data;

    public ResponseVo() {
    }

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseVo(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public  static <T>ResponseVo<T> success(T data){

        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(),data);

    }

    public  static <T>ResponseVo<T> successship(T data){

        return new ResponseVo<T>(ShippingResponseEnum.NEW_ADDRESS_SUCCESS.getStatus(),
                ShippingResponseEnum.NEW_ADDRESS_SUCCESS.getMsg()
                ,data);

    }

    public  static <T>ResponseVo<T> success(ShippingResponseEnum shippingResponseEnum){

        return new ResponseVo<T>(shippingResponseEnum.getStatus(),shippingResponseEnum.getMsg());
    }

    public static <T> ResponseVo<T> success(){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(),
                ResponseEnum.SUCCESS.getDesc());
    }


    public static <T> ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<T>(responseEnum.getCode(), responseEnum.getDesc());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg){
        return new ResponseVo<T>(responseEnum.getCode(), msg);
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult){
        return new ResponseVo<T>(responseEnum.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getField()+"  "+
                bindingResult.getFieldError().getDefaultMessage());
    }

    public static <T>ResponseVo<T> error(ShippingResponseEnum shippingResponseEnum) {

        return new ResponseVo<T>(shippingResponseEnum.getStatus(),shippingResponseEnum.getMsg());
    }
}
