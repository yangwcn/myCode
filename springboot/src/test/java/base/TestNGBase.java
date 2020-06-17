package base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = {
        String.class
})
@WebAppConfiguration
@Rollback
@Slf4j
public class TestNGBase extends AbstractTransactionalTestNGSpringContextTests {
}
