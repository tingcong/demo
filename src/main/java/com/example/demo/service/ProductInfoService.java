package com.example.demo.service;

import com.example.demo.entity.sell.ProductInfo;
import com.example.demo.order.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hutingcong on 2017/10/10.
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);
    /**查询在架的商品列表*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /**减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);
}
