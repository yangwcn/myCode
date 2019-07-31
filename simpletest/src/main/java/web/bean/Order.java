package web.bean;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("order")
public class Order {
    private String number;
    @Resource
    private User user;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
