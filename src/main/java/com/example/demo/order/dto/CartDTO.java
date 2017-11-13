package com.example.demo.order.dto;

/**
 * 购物车
 * Created by hutingcong on 2017/10/11.
 */
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public String getProductId() {
        return productId;
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
