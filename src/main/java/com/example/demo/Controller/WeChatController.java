package com.example.demo.Controller;

import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * Created by hutingcong on 2017/10/13.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {
    private String APPID = "wxc61e686455c054da".trim();
    private String appsecret = "5fe41cd0fe029d681c5e3013a548bf09".trim();

    private final static Logger log = LoggerFactory.getLogger(BuyerProductController.class);

    /**
     * 手动获取授权
     *
     * @param code
     */
    @GetMapping(value = "/auth", produces = {"application/json;charset=UTF-8"})
    public void manualAuth(@RequestParam("code") String code) {
        log.info("进入auth方法...  code={}", code);
        String url = ("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID
                + "&secret=" + appsecret
                + "&code=" + code
                + "&grant_type=authorization_code").trim();
        RestTemplate restTemplate = new RestTemplate();
        String respones = restTemplate.getForObject(url, String.class);
        log.info("respones={}", respones);
    }


    @Autowired
    private WxMpService wxMpService;

    /**
     * 自动获取授权
     *
     * @param returnUrl 我们的网站
     */
    @GetMapping(value = "/authorize", produces = {"application/json;charset=UTF-8"})
    public String autoauthorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置 :在配置文件WechatMpConfig中已配置好

        //2.调用方法
        String url = "http://hutingcong.mynatapp.cc/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code，result={}", redirectUrl);
        //重定向
        return "redirect:" + redirectUrl;

    }

    @GetMapping(value = "/userInfo", produces = {"application/json;charset=UTF-8"})
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
//            e.printStackTrace();
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:"+"https://www.baidu.com"+"?openid="+openId;
    }
}
