package webSocket.service;


import webSocket.server.MyWebSocket;

public interface IJudgeAndMessage {
    public boolean isSend(MyWebSocket myWebSocket);

    public String message(MyWebSocket myWebSocket);
}
