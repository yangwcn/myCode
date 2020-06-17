package designpattern.singleton;

/**
 * @author yangwcn
 * @date 2020-6-18 00:43:38
 * 懒汉
 * 因为锁所以效率低
 */
public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if(null == singleton3) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
