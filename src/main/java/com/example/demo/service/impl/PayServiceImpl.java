package com.example.demo.service.impl;

import com.example.demo.order.dto.OrderDTO;
import com.example.demo.service.PayService;
import com.example.demo.utils.GsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hutingcong on 2017/10/23.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private BestPayServiceImpl bestPayService;

    private final static String ORDER_NAME = "微信点餐订单";
    private final static Logger log= LoggerFactory.getLogger(PayServiceImpl.class);

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】 request={}", GsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】 response={}",GsonUtil.toJson(payResponse));
        return payResponse;
    }
}
