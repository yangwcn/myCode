package designpattern.flyweight;

/**
 * @author yangwei
 */
public class Cilent {
    public static void main(String[] args) {
        FlyweightFactory.getFlyweight("test1").operate();
        FlyweightFactory.getFlyweight("test2").operate();
        FlyweightFactory.getFlyweight("test3").operate();

        FlyweightFactory.getFlyweight("test1").setIntrinsic("yangw1");
        FlyweightFactory.getFlyweight("test1").operate();
    }
    /**
     * 我的理解是类似于共享数据容器，例如线程池，连接池
     */
}
