package com.lss.controller;


import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by shuangshuangl on 2018/8/22.
 */
@ClientEndpoint
public class WebSocketClient {
    private Session session = null;
    private int count = 0;

    public WebSocketClient() {
        super();
    }

    public WebSocketClient(URI endpointURI) {
        super();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            this.session = container.connectToServer(WebSocketClient.class,endpointURI);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接建立成功后的调用方法
     *
     * @param session
     */

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("open hello benny open");


    }

    /**
     * 收到服务端消息后调用的方法
     *
     * @param message
     */
    @OnMessage
    public void onMessqge(String message) {
        System.out.println("server message:" + message);
        if (count < 10) {
            send("onMessage hello benny " + (++count));
        }
    }

    /**
     * 连接关闭调用的方法
     */

    @OnClose
    public void onClose() {
        System.out.println("连接关闭");
    }


    /**
     * 发送错误的时候调用的方法
     */
    @OnError
    public void onError(Throwable throwable) {
        System.out.println("发送错误");
        throwable.printStackTrace();
    }

    public void send(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                this.session.getBasicRemote().flushBatch();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
