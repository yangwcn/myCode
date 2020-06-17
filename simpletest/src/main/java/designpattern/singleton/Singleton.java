package designpattern.singleton;

/**
 * @author yangwei
 * @date 2020-6-18 00:37:34 modify
 * 直接初始化静态变量。这样就保证了线程安全
 * 饿汉
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
