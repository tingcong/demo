package com.example.demo.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.ejb.MessageDriven;

/**
 * Created by hutingcong on 2017/7/30.
 */
@Controller
public class WsController {
    //当浏览器向服务端发送请求时，通过MessageMapping映射/welcom这个地址，类似RequestMapping
    @MessageMapping("/welcome")
    //当服务端有消息时，会对订阅了SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("welcom,"+message.getName()+"!");
    }
}
