package com.example.demo.order.service.impl;

import com.example.demo.order.dataobject.OrderDetail;
import com.example.demo.order.dataobject.OrderMaster;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.enums.OrderStatusEnum;
import com.example.demo.order.enums.PayStatusEnum;
import groovy.util.logging.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterServiceImplTest {
    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("胡廷聪");
        orderDTO.setBuyerPhone("13062829857");
        orderDTO.setBuyerOpenid("110110");
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123458");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(99);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderMasterService.create(orderDTO);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderMasterService.findOne("1507735792971632875");
        Assert.assertEquals("1507735792971632875", orderDTO.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 10);
        Page<OrderDTO> orderDTOPage = orderMasterService.findList("110110", request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderMasterService.findOne("1507735792971632875");
        OrderDTO result=orderMasterService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderMasterService.findOne("1507735792971632875");
        OrderDTO result=orderMasterService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void pay() throws Exception {
        OrderDTO orderDTO = orderMasterService.findOne("1507735792971632875");
        OrderDTO result=orderMasterService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list(){
        PageRequest request = new PageRequest(0, 10);
        Page<OrderDTO> orderDTOPage = orderMasterService.findList( request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

}