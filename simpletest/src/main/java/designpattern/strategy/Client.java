package designpattern.strategy;

/**
 * @author yangwei
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy1();
        Context context = new Context(strategy);
        context.doanything();

        Strategy otherStrategy = new ConcreteStrategy2();
        Context otherContext = new Context(otherStrategy);
        otherContext.doanything();
    }
    /**
     * 策略模式提供了对“开闭原则”的完美支持，
     * 用户可以在不修改原有系统的基础上选择算法或行为，
     * 也可以灵活地增加新的算法或行为。
     */
}
