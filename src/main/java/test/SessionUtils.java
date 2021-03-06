package test;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shuangshuangl on 2018/8/22.
 */
public class SessionUtils {
    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    public static void put(String relationId, int userCode, Session session){
        clients.put(getKey(relationId, userCode), session);
    }

    public static Session get(String relationId, int userCode){
        return clients.get(getKey(relationId, userCode));
    }

    public static void remove(String relationId, int userCode){
        clients.remove(getKey(relationId, userCode));
    }

    /**
     * 判断是否有连接
     * @param relationId
     * @param userCode
     * @return
     */
    public static boolean hasConnection(String relationId, int userCode) {
        return clients.containsKey(getKey(relationId, userCode));
    }

    /**
     * 组装唯一识别的key
     * @param relationId
     * @param userCode
     * @return
     */
    public static String getKey(String relationId, int userCode) {
        return relationId + "_" + userCode;
    }

}
