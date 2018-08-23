package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by shuangshuangl on 2018/8/22.
 */

@ServerEndpoint("/websocket.ws/{relationId}/{userCode}")
public class WebSocketServerTest {
    private static Log log = LogFactory.getLog(WebSocketServerTest.class);

    /**
     * 打开连接时触发
     *
     * @param relationId
     * @param userCode
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("relationId") String relationId,
                       @PathParam("userCode") int userCode,
                       Session session) {
        log.info("Websocket Start Connecting: " + SessionUtils.getKey(relationId, userCode));
        SessionUtils.put(relationId, userCode, session);

        try {
            session.getBasicRemote().sendText("Got your first message (" + relationId + ").Thanks !");
            int i = 0;
            while (i < 3) {

                session.getBasicRemote().sendText("Got your later message " + i);

                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到客户端消息时触发
     *
     * @param relationId
     * @param userCode
     * @param message
     * @return
     */
    @OnMessage
    public void onMessage(@PathParam("relationId") String relationId,
                          @PathParam("userCode") int userCode,
                          String message, Session session) {
        try {
            session.getBasicRemote().sendText("Got your first message (" + message + ").Thanks !");
            int i = 0;

            while (i < 3) {
                session.getBasicRemote().sendText("Got your later message " + i);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常时触发
     *
     * @param relationId
     * @param userCode
     * @param session
     */
    @OnError
    public void onError(@PathParam("relationId") String relationId,
                        @PathParam("userCode") int userCode,
                        Throwable throwable,
                        Session session) {
        log.info("Websocket Connection Exception: " + SessionUtils.getKey(relationId, userCode));
        log.info(throwable.getMessage(), throwable);
        SessionUtils.remove(relationId, userCode);
    }

    /**
     * 关闭连接时触发
     *
     * @param relationId
     * @param userCode
     * @param session
     */
    @OnClose
    public void onClose(@PathParam("relationId") String relationId,
                        @PathParam("userCode") int userCode,
                        Session session) {
        log.info("Websocket Close Connection: " + SessionUtils.getKey(relationId, userCode));
        SessionUtils.remove(relationId, userCode);
    }
}
