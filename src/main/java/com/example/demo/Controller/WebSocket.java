//package com.example.demo.Controller;
//
//import com.example.demo.seller.controller.SellerUserController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * Created by hutingcong on 2017/11/1.
// */
//@Component
//@ServerEndpoint("/webSocket")
//public class WebSocket {
//
//    private static final Logger log = LoggerFactory.getLogger(SellerUserController.class);
//
//    private Session session;
//
//    //定义容器，储存session
//    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
//
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
//        webSocketSet.add(this);
//        log.info("【websocket消息】有新的连接，总数是:{}", webSocketSet.size());
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        webSocketSet.remove(this);
//        log.info("【websocket消息】连接断开，总数是:{}", webSocketSet.size());
//    }
//
//    @OnMessage
//    public void onMessage(String msg) {
//        webSocketSet.remove(this);
//        log.info("【websocket消息】收到客户发来的消息，{}", msg);
//    }
//
//    /**
//     * 广播的形式发送
//     * @param msg
//     */
//    public void sendMessage(String msg) {
//        for (WebSocket webSocket:webSocketSet){
//            log.info("【websocket消息】广播消息，{}", msg);
//            try {
//                webSocket.session.getBasicRemote().sendText(msg);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
