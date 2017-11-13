package com.example.demo.seller.service;

import com.example.demo.seller.dataobject.SellerInfo;

/**
 * Created by hutingcong on 2017/10/31.
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenId(String openid);
}
