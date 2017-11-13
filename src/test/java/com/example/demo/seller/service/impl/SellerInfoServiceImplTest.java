package com.example.demo.seller.service.impl;

import com.example.demo.seller.dataobject.SellerInfo;
import com.example.demo.seller.repository.SellerInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Test
    public void findSellerInfoByOpenId() throws Exception {
        SellerInfo result=sellerInfoRepository.findByOpenid("abc");
        Assert.assertNotNull(result);
    }

}