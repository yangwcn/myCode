package webSocket.server;

import com.alibaba.fastjson.JSONObject;
import kafka.KafkaManager;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import webSocket.util.ServerEncoder;
import webSocket.util.WebSocketSession;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
/*@Scope(value="prototype")*/
@ServerEndpoint(
        value="/websocket/{orgId}/{accId}",
        encoders = {ServerEncoder.class}
)
public class MyWebSocket {
    private static KafkaManager kafkaManager;

    public MyWebSocket(){
        System.out.println("MyWebSocket+========================");
    }
    private final static Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = WebSocketSession.webSocketSet;

    private static int onlineCount = 0;

    private Session session;

    // 企业ID
    @Getter
    private  String orgId;
    // 云信accid
    @Getter
    private  String accId;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("orgId") String orgId,
                       @PathParam("accId") String accId, Session session){
        this.session = session;
        this.orgId = orgId;
        this.accId = accId;
        webSocketSet.add(this);
        addOnlineCount();//在线数加1
        logger.info("有新连接加入！当前在线人数为" + getOnlineCount()+",orgId"+this.orgId+",accId"+ this.accId + ",session" + session.getId());

        kafkaManager.writeMessage();

        try {
            afterConnectionEstablished(this.orgId , this.accId, session) ;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount()+"orgId"+this.orgId+"accId"+this.accId);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(message);
    }

    /**
     * 发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        /*
         * modify by Chi Lichao 2019/05/10
         * 加synchronized块
         * 解决报错  RuntimeException java.lang.IllegalStateException ERROR java.lang.IllegalStateException:
         * The remote endpoint was in state [TEXT_FULL_WRITING] which is an invalid state for called method
         * */
        synchronized(session){
            this.session.getBasicRemote().sendText(message);
            /*try {
                this.session.getBasicRemote().sendObject(user);
            } catch (EncodeException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void sendMessage(Object message){
        try {
            for (MyWebSocket myWebSocket : webSocketSet) {
                myWebSocket.sendMessage(message.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        logger.info("连接发生了错误" + getOnlineCount());
        logger.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
        error.printStackTrace();
    }

    @Autowired
    public void setKafkaManager(KafkaManager kafkaManager) {
        MyWebSocket.kafkaManager = kafkaManager;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    /**
     * 心跳检测逻辑
     */
    private Timer timer;

    public void afterConnectionEstablished(String orgId , String accId , Session session) {
        timer = new Timer(true);
        long delay = 0;
        MyWebSocket.OrderTimeTask orderTimeTask = new MyWebSocket.OrderTimeTask(orgId , accId,session);
        timer.schedule(orderTimeTask,delay, 60000);// 设定指定的时间time,此处为1分钟
    }

    class OrderTimeTask extends TimerTask {
        private Session session;
        private String orgId;
        private String accId;

        public OrderTimeTask(String orgId, String accId, Session session2) {
            this.orgId = orgId;
            this.accId = accId;
            this.session = session2;
        }

        @Override
        public void run() {
            try {
                if (session == null || !session.isOpen()) {
                    timer.cancel();
                    return;
                }
                String message = "ping";
                this.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
