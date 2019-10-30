package testng.Service.Impl;

import org.springframework.stereotype.Service;
import testng.Service.TestngService;

@Service
public class TestngServiceImpl implements TestngService {

    public String getTestngString(String string) {
        return "return " + string;
    }
}
