package com.lss.service;

import com.lss.controller.WebSocketClient;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by shuangshuangl on 2018/8/22.
 */
public class WebSocketService {
    private  static String uri = "ws://localhost:8080/websocket";
    private  static Session session;
    public static void main(String[] args) {
       WebSocketService client = new WebSocketService();
       client.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        do {
            try {
                input = bufferedReader.readLine();
                if (!input.equals("exit")){
                    client.session.getBasicRemote().sendText("javaclient"+input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (!input.equals("exit"));
    }

    private void  start(){
        WebSocketContainer container = null;
        container = ContainerProvider.getWebSocketContainer();

        URI r = URI.create(uri);
        try {
            session = container.connectToServer(WebSocketClient.class,r);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
