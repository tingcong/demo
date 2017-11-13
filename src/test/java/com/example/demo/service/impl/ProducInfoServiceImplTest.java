package com.example.demo.service.impl;

import com.example.demo.entity.sell.ProductInfo;
import com.example.demo.entity.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/10/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducInfoServiceImplTest {
    @Autowired
    private ProducInfoServiceImpl producInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo=producInfoService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList=producInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> productInfoPage=producInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("fsffd");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo productInfo1=producInfoService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

}