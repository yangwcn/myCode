package web.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
    @Pointcut("execution(* web.bean.User.getName(..))")
    private void getName() {}

    @Before("getName()")
    public void before() {
        System.out.println("log before");
    }

    @After("getName()")
    public void after() {
        System.out.println("log after");
    }
}
