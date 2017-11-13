package com.example.demo.service;

import com.example.demo.entity.sell.ProductCategory;

import java.util.List;

/**
 * Created by hutingcong on 2017/10/9.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
