package designpattern.abstractfactory;

/**
 * @author yangwei
 * @date 2020-6-15 14:35:53
 */
public class ConcreteCreaterB extends Creater {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product p = null;
        try {
            p = (Product)Class.forName(c.getName()).newInstance();
            p.methodB();
            p.methodA();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)p;
    }
}
