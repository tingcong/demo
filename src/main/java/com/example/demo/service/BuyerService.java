package com.example.demo.service;

import com.example.demo.order.dto.OrderDTO;

/**
 * Created by hutingcong on 2017/10/12.
 */
public interface BuyerService {
    //查询单个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
