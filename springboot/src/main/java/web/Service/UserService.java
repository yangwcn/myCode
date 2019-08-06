package web.Service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.bean.Hotel;
import web.bean.TestA;
import web.bean.User;
import web.dao.HotalDAO;
import web.dao.TestaMapper;
import web.dao.UserDAO;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private HotalDAO hotalDAO;
    @Autowired
    private TestaMapper testADAO;


    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
    public User getUser(String name) {
        return userDAO.getUser(name);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED, timeout = 1)
    public int insertUser(User user) {
        return userDAO.insertUser(user);
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

    public List<TestA> getAllTestA(RowBounds rowBounds){
        return this.testADAO.getAll(rowBounds);
    }
}
