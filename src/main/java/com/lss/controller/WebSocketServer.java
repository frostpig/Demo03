package com.lss.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.URI;

/**
 * Created by shuangshuangl on 2018/8/22.
 */
@ServerEndpoint("/websocket")
public class WebSocketServer {
    private int count = 0;

    /**
     * 连接建立成功后的调用方法
     *
     * @param session
     */

    @OnOpen
    public void onOpen(Session session) {
        try {
            RemoteEndpoint.Basic basic = session.getBasicRemote();
            URI requestUri = session.getRequestURI();
            basic.sendText(requestUri.getPath() + requestUri.getQuery());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到客户端消息调用的方法
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("client message" + message);
        final Session session1 = session;
        try {
            session.getBasicRemote().sendText("say count" + (++count));
            session.getBasicRemote().flushBatch();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            session1.getBasicRemote().sendText("hello benny" + (++count) + "\r\n");
                            session1.getBasicRemote().flushBatch();
                            Thread.sleep(1000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WebSocket请求关闭
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("onClose end");
    }

    /**
     * 发生错误时调用
     * @param throwable
     */
    @OnError
    public void onError(Throwable throwable) {
         throwable.printStackTrace();
    }
}
