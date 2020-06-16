package designpattern.builder;

/**
 * @author yangwei
 * @date 2020-6-16 14:35:31
 */
public abstract class AbstractBuilder {
    Product product = new Product();

    abstract void buildAttrA();

    abstract void buildAttrB();

    abstract void buildAttrC();

    public Product getProduct() {
        return product;
    }
}
