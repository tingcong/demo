package com.example.demo.order.service;

import com.example.demo.order.dataobject.OrderMaster;
import com.example.demo.order.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by hutingcong on 2017/10/11.
 */
public interface OrderMasterService {
    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String  buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //接单（完结订单）
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO pay(OrderDTO orderDTO);

    //订单列表
    Page<OrderDTO> findList(Pageable pageable);
}
