package test;

import javax.websocket.*;

/**
 * Created by shuangshuangl on 2018/8/22.
 *
 * 依赖Java-WebSocket
 */
@ClientEndpoint
public class WebSocketClientTest {

    @OnOpen
    public void onOpen(Session session){
        System.out.println("Connected to endPoint :"+ session.getBasicRemote());
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println(message);
    }

    @OnError
    public void  onError(Throwable e){
        e.printStackTrace();
    }


}
