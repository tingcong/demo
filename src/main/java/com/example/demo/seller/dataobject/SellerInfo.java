package com.example.demo.seller.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hutingcong on 2017/10/31.
 */
@Entity
public class SellerInfo {
    @Id
    private  String sellerId;

    private String username;

    private String password;

    private String openid;

    public SellerInfo() {
    }

    public SellerInfo(String sellerId, String username, String password, String openid) {
        this.sellerId = sellerId;
        this.username = username;
        this.password = password;
        this.openid = openid;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
