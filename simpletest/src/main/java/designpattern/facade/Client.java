package designpattern.facade;

/**
 * @author yangwei
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
    /**
     * 引入外观模式，是客户对子系统的使用变得简单了，减少了与子系统的关联对象，实现了子系统与客户之间的松耦合关系。
     */
}
