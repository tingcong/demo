package com.example.demo.seller.repository;

import com.example.demo.seller.dataobject.SellerInfo;
import com.example.demo.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hutingcong on 2017/10/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo(KeyUtil.genUniqueKey(), "admin", "admin", "abc");
        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = sellerInfoRepository.findByOpenid("abc");
        Assert.assertNotNull(result);
    }
}