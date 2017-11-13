package com.example.demo.order.repository;

import com.example.demo.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositryTest {
    @Autowired
    private OrderDetailRepositry repositry;

    @Test
    public void saveTest() throws Exception {
        OrderDetail orderDetail=new OrderDetail("1234567890","11111112","123457","皮蛋粥",new BigDecimal(1.2),2,"fdsfdfd");
        OrderDetail result=repositry.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> result=repositry.findByOrderId("11111112");
        Assert.assertNotEquals(0,result.size());
    }

}