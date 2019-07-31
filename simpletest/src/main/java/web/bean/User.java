package web.bean;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
    private String name;
    private String password;

    public String getName() {
        System.out.println("User's name");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
