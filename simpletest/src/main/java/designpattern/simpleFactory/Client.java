package designpattern.simpleFactory;

/**
 * @author yangwei
 * @date 2020-6-15 14:12:06
 */
public class Client {
    public static void main(String[] argss) {
        AbstractProduct productA = ProductFactory.creatProduce("A");
        AbstractProduct productB = ProductFactory.creatProduce("B");
    }
    /**
     * 是由一个工厂对象决定创建出哪一种产品类的实例
     */
}
