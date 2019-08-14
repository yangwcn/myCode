package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"kafka", "webSocket"})
@SpringBootApplication
//@EnableAutoConfiguration
public class AllApplication {
    public static void main(String[] args) {
        SpringApplication.run(AllApplication.class, args);
    }
}
