package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.Service.UserService;
import web.bean.User;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {
    @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("test.do")
    public String test(){
        String result = "test";
        System.out.println(result);
        return result;
    }

    @RequestMapping("redirected.do")
    public String redirected() {
        return "redirect:test.do";
    }

    @RequestMapping("user.do")
    public String gotoUserPage() {
        System.out.println(System.getProperty("file.encoding"));
        return "user";
    }

    @RequestMapping("add.do")
    @ResponseBody
    public User add(String name, String password) {
        System.out.println(name);
        System.out.println(password);
        List<User> userList = this.userService.getAllUser();
        return userList.get(0);
    }
}
