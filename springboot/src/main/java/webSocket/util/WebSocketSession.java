package webSocket.util;

import webSocket.server.MyWebSocket;

import java.util.concurrent.CopyOnWriteArraySet;

public class WebSocketSession {
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
}
