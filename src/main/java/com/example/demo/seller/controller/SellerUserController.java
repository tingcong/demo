package com.example.demo.seller.controller;

import com.example.demo.config.ProjectUrlConfig;
import com.example.demo.constant.CookieConstant;
import com.example.demo.constant.RedisConstant;
import com.example.demo.enums.ResultEnum;
import com.example.demo.seller.dataobject.SellerInfo;
import com.example.demo.seller.service.SellerService;
import com.example.demo.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutingcong on 2017/10/31.
 */
@Controller
@RequestMapping(value = "/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    private static final Logger log = LoggerFactory.getLogger(SellerUserController.class);

    @GetMapping(value = "/login")
    public void login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        //1. 匹配openid
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openid);
        if (sellerInfo == null) {
            map.put("url", "common/error");
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
        }
        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        //4.登录成功，跳转首页
//        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/order/list");
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map) {
        //1.从cookie查询
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null){
            //2.清除redis
        redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,RedisConstant.EXPIRE_NONE);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/order/list");

        //4.登出成功，页面跳转
//        return new ModelAndView("common/success",map);
    }
}
