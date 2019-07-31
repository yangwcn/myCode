package Design_Pattern.factory;

public class ConcreteCreater extends Creater {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product p = null;
        try {
            p = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)p;
    }
}
