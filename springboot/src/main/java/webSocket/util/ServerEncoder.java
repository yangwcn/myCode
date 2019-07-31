package webSocket.util;

import web.bean.User;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ServerEncoder implements Encoder.Text<User> {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void init(EndpointConfig arg0) {
        // TODO Auto-generated method stub

    }

    public String encode(User socketMsg) {
        try {
            return socketMsg.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
}
