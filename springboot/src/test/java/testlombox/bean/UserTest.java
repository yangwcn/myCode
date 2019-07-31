package testlombox.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testlombox(){
        User user = new User();
        user.setName("yangwcn");
        user.setPassword("yangwcn");
        System.out.println(user.toString());
        System.out.println(user.hashCode());

        User user1 = new User("yangwcn","yangwcn");
        System.out.println(user.equals(user1));
    }
}