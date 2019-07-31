package web.dao;

import web.bean.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();

    public User getUser(String name);
}
