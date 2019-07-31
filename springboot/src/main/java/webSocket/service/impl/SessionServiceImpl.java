package webSocket.service.impl;

import webSocket.server.MyWebSocket;
import org.springframework.stereotype.Service;
import webSocket.service.IJudgeAndMessage;
import webSocket.service.ISessionService;
import webSocket.util.WebSocketSession;

import java.io.IOException;
import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {
    @Override
    public void sentMessageByOrgId(String orgId, String message) {
        for(MyWebSocket myWebSocket: WebSocketSession.webSocketSet){
            try {
                if(orgId.equals(myWebSocket.getOrgId())){
                    myWebSocket.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void sentMessageByOrgIds(List<String> userId, String message) {

    }

    @Override
    public void sentMessageByOrgIdAndUserId(String orgId, String userId, String message) {

    }

    @Override
    public void sentMessageByOrgIdAndUserIds(String orgId, List<String> userId, String message) {

    }

    @Override
    public void sentMeassgeByIJudgeAndMessage(IJudgeAndMessage judgeAndMessage) {
        for(MyWebSocket myWebSocket: WebSocketSession.webSocketSet){
            try {
                if(judgeAndMessage.isSend(myWebSocket)){
                    myWebSocket.sendMessage(judgeAndMessage.message(myWebSocket));
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
