package com.example.demo.service;

import com.example.demo.order.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * Created by hutingcong on 2017/10/23.
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
