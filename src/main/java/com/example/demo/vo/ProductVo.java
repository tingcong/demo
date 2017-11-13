package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 商品，包含类目
 * Created by hutingcong on 2017/10/11.
 */
public class ProductVo {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public ProductVo(String categoryName, Integer categoryType, List<ProductInfoVO> productInfoVOList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVOList = productInfoVOList;
    }

    public ProductVo() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }
}
