package designpattern.singleton;

/**
 * @author yangwei
 * @date 2020-6-18 00:42:22 modify
 * 用“双重检查加锁”，在getInstance()中减少使用同步
 * 双锁
 */
public class Singleton2 {
    private static volatile Singleton2 singleton2;

    Singleton2() {}

    public Singleton2 getInstance() {

        if(singleton2 == null) {
            synchronized(Singleton2.class) {
                if(singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
