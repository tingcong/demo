package com.example.demo.service.impl;

import com.example.demo.Controller.BuyerProductController;
import com.example.demo.enums.ResultEnum;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.exception.SellException;
import com.example.demo.order.service.OrderMasterService;
import com.example.demo.service.BuyerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hutingcong on 2017/10/12.
 */
@Service
public class BuyerServiceImpl implements BuyerService {
    private final static Logger log = LoggerFactory.getLogger(BuyerProductController.class);
    @Autowired
    private OrderMasterService orderMasterService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("【查询订单】查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderMasterService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderMasterService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={},orderId={}", openid, openid);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
