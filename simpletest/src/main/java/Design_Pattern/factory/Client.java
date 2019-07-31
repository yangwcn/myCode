package Design_Pattern.factory;

public class Client {
    public static void main(String[] args) {
        Creater c = new ConcreteCreater();
        Product p = c.createProduct(ConcreteProduct1.class);
        p.method1();
        p.method2();
    }
}
