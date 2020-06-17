package designpattern.abstractfactory;

public class Client {
    public static void main(String[] args) {
        Creater concreteCreaterA = new ConcreteCreaterA();
        Creater concreteCreaterB = new ConcreteCreaterB();
        Product product1 = concreteCreaterA.createProduct(ConcreteProduct1.class);
        Product product2 = concreteCreaterA.createProduct(ConcreteProduct2.class);
        Product product3 = concreteCreaterA.createProduct(ConcreteProduct1.class);
    }
    /**
     * 不在工厂类中进行逻辑判断，程序可以为不同产品类提供不同的工厂，不同的工厂类和产不同的产品。
     * 当使用工厂方法设计模式时，对象调用者需要与具体的工厂类耦合
     */
}
