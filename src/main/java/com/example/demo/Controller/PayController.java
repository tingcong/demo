package com.example.demo.Controller;

import com.example.demo.enums.ResultEnum;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.exception.SellException;
import com.example.demo.order.service.OrderMasterService;
import com.example.demo.service.PayService;
import com.google.common.collect.Maps;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 * Created by hutingcong on 2017/10/23.
 */
@Controller
@RequestMapping(value = "pay")
public class PayController {
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private PayService payService;

    @GetMapping(value = "/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                                @RequestParam("returnUrl") String returnUrl) {
        //查询订单
        OrderDTO orderDTO = orderMasterService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
       PayResponse response= payService.create(orderDTO);
        Map map_t= Maps.newHashMap();
        map_t.put("respones",response);
        return new ModelAndView("pay/create",map_t);
    }
}
