package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import web.Service.UserService;
import web.bean.Order;
import web.bean.User;
import web.springjdbctemp.UserJDBCTemplate;

@RestController
public class HelloController {
    /*@Value("${yangw.name}")
    private String name;*/
    /*@Autowired
    private User user;
    @Autowired
    private Order order;*/
    /*@Autowired
    UserJDBCTemplate jdbcTemplate;*/
    @Autowired
    UserService userService;
    @RequestMapping("/hello")
    public String sayHello() {
        return userService.getUser("test").getName() + "Hello,World!";
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("/test.jsp");
    }

    @RequestMapping("/insert")
    public String insert() {
        User user = new User();
        user.setName("insert111111111111111111111111111111111111111");
        user.setPassword("insert11111111111111111111111111111111111111111");
        return String.valueOf(userService.insertUser(user));
    }
}
