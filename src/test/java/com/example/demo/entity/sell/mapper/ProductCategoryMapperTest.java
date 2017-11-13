package com.example.demo.entity.sell.mapper;

import com.example.demo.entity.sell.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by hutingcong on 2017/11/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "宁玲最爱");
        map.put("category_type", 4);
        int flag = mapper.insertByMap(map);
        Assert.assertEquals(flag,1);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryType(5);
        productCategory.setCategoryName("美珍最爱");
        int flag = mapper.insertByObject(productCategory);
        Assert.assertEquals(flag,1);
    }

    @Test
    public void findByCategoryType() throws Exception {
        ProductCategory productCategory=mapper.findByCategoryType(4);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryName() throws Exception {
        List<ProductCategory> productCategory=mapper.findByCategoryName("宁玲最爱");
        Assert.assertNotEquals(0,productCategory.size());
    }

    @Test
    public void updateCategory() throws Exception {
        int flag=mapper.updateCategory(6,"聪聪最爱");
        Assert.assertNotEquals(flag,0);
    }

    @Test
    public void updateByObject() throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryType(6);
        productCategory.setCategoryName("宁玲最爱");
        int flag = mapper.updateByObject(productCategory);
        Assert.assertEquals(flag,1);
    }
}