package web.dao;

import org.springframework.stereotype.Repository;
import web.bean.User;

import java.util.List;

@Repository
public interface UserDAO {
    public List<User> getAllUser();

    public User getUser(String name);

    public int insertUser(User user);
}
