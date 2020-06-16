package designpattern.builder;

/**
 * @author yangwei
 * @date 2020-6-16 14:42:18
 */
public class ConcreteBuildA extends AbstractBuilder {
    @Override
    public void buildAttrA() {
        this.product.setAttributeA("buildA set attrA");
    }

    @Override
    public void buildAttrB() {
        this.product.setAttributeB("buildA set attrB");
    }

    @Override
    public void buildAttrC() {
        this.product.setAttributeC("buildA set attrC");
    }
}
