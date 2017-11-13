package com.example.demo.aspect;

import com.example.demo.constant.CookieConstant;
import com.example.demo.constant.RedisConstant;
import com.example.demo.exception.SellerAuthorizeException;
import com.example.demo.utils.CookieUtil;
import org.apache.http.protocol.RequestContent;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hutingcong on 2017/11/1.
 */
@Aspect
@Component
public class SellerAuthorizeAspect {
    private final static Logger log = LoggerFactory.getLogger(SellerAuthorizeAspect.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.example.demo.Controller.*.*(..))" )   //切入点
//    +
//            "&& !execution(public * com.example.demo.seller.controller.SellerUser*.*(..))"
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(11111);
        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        //去redis里查
        String token = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if(StringUtils.isEmpty(token)){
            log.warn("【登录校验】redis中查不到token值");
            throw new SellerAuthorizeException();
        }

    }
}
