package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

@SpringBootTest(classes = {
        String.class
})
@WebAppConfiguration
@Rollback
public class TestNGControllerBase extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mvc;

    //@Parameters({"userId"})
    @BeforeClass
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
