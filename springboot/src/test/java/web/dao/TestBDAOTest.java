package web.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.jpadao.TestBDAO;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBDAOTest {

    @Autowired
    TestBDAO testBDAO;

    @Test
    public void test() {
        testBDAO.getTestB("test");
    }

}