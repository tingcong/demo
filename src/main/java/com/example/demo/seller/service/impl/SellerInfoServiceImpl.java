package com.example.demo.seller.service.impl;

import com.example.demo.seller.dataobject.SellerInfo;
import com.example.demo.seller.repository.SellerInfoRepository;
import com.example.demo.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hutingcong on 2017/10/31.
 */
@Service
public class SellerInfoServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
