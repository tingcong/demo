package com.example.demo.order.repository;

import com.example.demo.order.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() throws Exception {
        OrderMaster orderMaster=new OrderMaster("1234567","师兄","123456789123","慕课网","110110",new BigDecimal(2.5));
        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request=new PageRequest(0,10);
        Page<OrderMaster> result=repository.findByBuyerOpenid("110110",request);
        System.out.println(result.getTotalElements());
    }

}