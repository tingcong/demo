package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置websocket
 * Created by hutingcong on 2017/7/30.
 */
@Configuration
@EnableWebSocketMessageBroker   //开启使用STOMP协议来传输基于代理（message broker）的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 注册STOMP协议的节点，并映射的指定的URL
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个STOMP协议的节点，并指定使用sockJS协议
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
    }

    //配置消息代理（message broker）
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic");
    }
}
