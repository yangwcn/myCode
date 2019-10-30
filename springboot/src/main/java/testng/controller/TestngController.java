package testng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import testng.Service.TestngService;

import javax.annotation.Resource;

@Controller("/testng")
public class TestngController {
    @Resource
    private TestngService testngService;

            @RequestMapping("/testngString")
    @ResponseBody
    public Object testngString(String string) {
        return testngService.getTestngString(string);
    }
}
