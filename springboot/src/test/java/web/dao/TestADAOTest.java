package web.dao;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.Service.UserService;
import web.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestADAOTest {
    @Autowired
    UserService userService;
    @Autowired
    User user;
    @Test
    public void testGetAll() {
        //System.out.println(testADAO.getAll());
        System.out.println(userService.getAllTestA(new RowBounds(0,2)));
    }
    @Test
    public void testUser() {
        //System.out.println(testADAO.getAll());
        System.out.println(user.getName());
    }
}