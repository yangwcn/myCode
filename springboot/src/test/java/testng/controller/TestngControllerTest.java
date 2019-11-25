package testng.controller;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.WebTestngApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.*;

@SpringBootTest(classes = {
        WebTestngApplication.class
})
@WebAppConfiguration
public class TestngControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestngController controller;

    private MockMvc mockMvc;

    @BeforeClass
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testTestngString() throws Exception {
        this.mockMvc.perform(post("/testng/testngString?string=111" ))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("return 111"));
    }
}