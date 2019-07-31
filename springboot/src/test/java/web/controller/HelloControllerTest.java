package web.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloControllerTest {
    @Test
    public void testSayHello() {
        assertEquals("Hello,World!",new HelloController().sayHello());
    }
}