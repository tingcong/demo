package com.example.demo.websocket;

/**
 * 服务器向浏览器发送的此类消息
 * Created by hutingcong on 2017/7/30.
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
