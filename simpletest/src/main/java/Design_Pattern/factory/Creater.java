package Design_Pattern.factory;

public abstract class Creater {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
