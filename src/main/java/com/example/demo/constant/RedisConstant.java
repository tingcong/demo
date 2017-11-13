package com.example.demo.constant;

/**
 * Redis常量
 * Created by hutingcong on 2017/10/31.
 */
public interface RedisConstant {
    Integer EXPIRE=7200;//2小时
    Integer EXPIRE_NONE=0;//清除cookie的时候使用
    String TOKEN_PREFIX="token_%s";
}
