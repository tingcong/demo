package com.example.demo.Controller;

import com.example.demo.enums.ResultEnum;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.service.OrderMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by hutingcong on 2017/10/28.
 */
@Controller
@RequestMapping(value = "order")
public class SellOrderController {

    @Autowired
    private OrderMasterService orderMasterService;

    private final static Logger log = LoggerFactory.getLogger(SellOrderController.class);

    /**
     * @param page 默认从第一页开始
     * @param size
     * @return
     */
    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "2") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderMasterService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    @GetMapping(value = "/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderMasterService.findOne(orderId);
            orderMasterService.cancel(orderDTO);
        } catch (Exception e) {
            log.error("【卖家端取消订单】 发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/order/list");
        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping(value = "/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderMasterService.findOne(orderId);
        } catch (Exception e) {
            log.error("【卖家端查询订单详情】 发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * 完结订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping(value = "/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderMasterService.findOne(orderId);
            orderMasterService.finish(orderDTO);
        } catch (Exception e) {
            log.error("【卖家端查询订单详情】 发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/order/list");
        return new ModelAndView("common/success");
    }
}
