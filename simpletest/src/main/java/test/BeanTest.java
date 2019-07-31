package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import web.Service.UserService;
import web.bean.Order;
import web.bean.User;
import web.springjdbctemp.UserJDBCTemplate;

import java.util.Arrays;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) throws Exception{
        System.out.println(ResourceUtils.getURL("classpath:").toString());
        System.out.println(new ClassPathResource("").getPath());
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext(new ClassPathResource("/config/spring/applicationcontext.xml"));
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.getName());

        Order order = (Order)applicationContext.getBean("order");
        System.out.println(order.getUser().getName());

        UserJDBCTemplate jdbcTemplate = (UserJDBCTemplate)applicationContext.getBean("UserTemplate");
        List<User> allUser = jdbcTemplate.getAllUser();
        for (User tuser : allUser) {
            System.out.println(tuser.getName());
            System.out.println(tuser.getPassword());
        }

        UserService us = (UserService)applicationContext.getBean("userService");
        List<User> allUserInus = us.getAllUser();
        for (User tuser : allUserInus) {
            System.out.println(tuser.getName());
            System.out.println(tuser.getPassword());
        }

        User tuser = us.getUser("test");
        System.out.println(tuser.getName());
        System.out.println(tuser.getPassword());



       /* String path = BeanTest.class.getResource("").getPath().
                replaceFirst("/","").toString().replace("TestPrint","config")
                + "Mybatis/SqlMapConfig.xml";
       try {
            InputStream inputStream = Resources.getResourceAsStream(path);
            //创建工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过工厂创建会话
            SqlSession openSession = factory.openSession();
            //第一个参数：所调用的sql语句：namespace+‘.’+SqlID
            //第二个参数：传入的参数
            User iuser = openSession.selectOne("TestPrint.findUserByName", "yangwcn");
            System.out.println(iuser.getName());
            openSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(path);*/
    }
}
