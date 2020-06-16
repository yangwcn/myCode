package designpattern.builder;

/**
 * @author yangwei
 * @date 2020-6-16 14:47:18
 */
public class Director {
    AbstractBuilder builder;

    public void setBuilder(AbstractBuilder builder) {
        this.builder = builder;
    }

    public Product getProduct() {
        builder.buildAttrA();
        builder.buildAttrB();
        builder.buildAttrC();
        return builder.getProduct();
    }
}
