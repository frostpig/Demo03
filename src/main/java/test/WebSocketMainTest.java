package test;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by shuangshuangl on 2018/8/22.
 */
public class WebSocketMainTest {
    public Session session;

    protected void start()
    {

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        String uri = "ws://127.0.0.1:8080/websocket.ws/relationId/12345";
        System.out.println("Connecting to " + uri);
        try {
            session = container.connectToServer(WebSocketClientTest.class, URI.create(uri));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        WebSocketMainTest client = new WebSocketMainTest();
        client.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            do{
                input = br.readLine();
                if(!input.equals("exit"))
                    client.session.getBasicRemote().sendText(input);

            }while(!input.equals("exit"));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
