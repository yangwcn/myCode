package web.Service;

import org.springframework.stereotype.Service;
import web.bean.Hotel;
import web.bean.User;
import web.dao.HotalDAO;
import web.dao.UserDAO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Resource
    private UserDAO userDAO;
    @Resource
    private HotalDAO hotalDAO;


    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
    public User getUser(String name) {
        return userDAO.getUser(name);
    }

    public Hotel getHotelById(int id) {
        return hotalDAO.getHotelById(id);
    }

    public HotalDAO getHotalDAO() {
        return hotalDAO;
    }

    public void setHotalDAO(HotalDAO hotalDAO) {
        this.hotalDAO = hotalDAO;
    }



    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
