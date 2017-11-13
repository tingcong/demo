package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信账号相关配置
 * Created by hutingcong on 2017/10/14.
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String appId;
    private String appSecret;

    /** 商户号*/
    private String mchId;
    /** 商户密码*/
    private String mchKey;
    /** 商户证书路径*/
    private String keyPath;
    /** 微信支付异步通知*/
    private String notifyUrl;
    public WechatAccountConfig() {
    }

    public WechatAccountConfig(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
