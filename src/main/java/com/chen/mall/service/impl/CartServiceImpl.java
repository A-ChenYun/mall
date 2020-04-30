package com.chen.mall.service.impl;

import com.chen.mall.consts.MallConst;
import com.chen.mall.dao.ProductMapper;
import com.chen.mall.enums.ProductEnum;
import com.chen.mall.enums.ResponseEnum;
import com.chen.mall.form.CartsForm;
import com.chen.mall.pojo.Cart;
import com.chen.mall.pojo.Product;
import com.chen.mall.service.ICartService;
import com.chen.mall.vo.CartVo;
import com.chen.mall.vo.ResponseVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;

/**
 * @Author AChen
 * @Data: 2020/3/19 2:54 下午
 */
@Transactional
@Service
public class CartServiceImpl implements ICartService {
  private   Gson gson = new Gson();
     Integer quantity = 1;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseVo<CartVo>add(Integer uid, CartsForm cartsForm) {
        //注入product
        Product product = productMapper.selectByPrimaryKey(cartsForm.getProductId());

        //判断商品是否存在
        if(product == null ){
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIT);
        }
        //判断商品还有不有库存
        if (product.getStock()<1){
            return  ResponseVo.error(ResponseEnum.NOT_HAVE_PRODUCT);
        }
        //判断商品是否在售
        if (!product.getStatus().equals(ProductEnum.ON_SALL)){
            return  ResponseVo.error(ResponseEnum.PRODUCT_DELATE_UNEXIT);

        }

        //写入redis
        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();
        opsForHash.put(String.format(MallConst.CART_REDIS_KEY_TEMPLATE,uid),
                String.valueOf(product.getId()),
                gson.toJson(new Cart(product.getId(),quantity,cartsForm.getSelected())));
        return ResponseVo.success();
    }
}
