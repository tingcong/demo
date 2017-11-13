package com.example.demo.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 微信自动获取授权配置
 * Created by hutingcong on 2017/10/14.
 */
//在annotaion配置注解中用@Component来表示一个通用注释用于说明一个类是一个spring容器管理的类。
// 即就是该类已经拉入到spring的管理中了
@Component
public class WechatMpConfig {
    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    /**
     * 配置
     */
    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(wechatAccountConfig.getAppId());
        wxMpConfigStorage.setSecret(wechatAccountConfig.getAppSecret());
        return wxMpConfigStorage;
    }
}
