package com.example.demo.service.impl;

import com.example.demo.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {
    @Autowired
    private BestPayServiceImpl bestPayService;
    @Test
    public void create() throws Exception {
        PayRequest payRequest=new PayRequest();
        bestPayService.pay(payRequest);
    }

}