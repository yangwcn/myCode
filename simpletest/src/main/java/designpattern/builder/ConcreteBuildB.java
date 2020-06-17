package designpattern.builder;

/**
 * @author yangwei
 * @date 2020-6-16 14:42:18
 */
public class ConcreteBuildB extends AbstractBuilder {
    @Override
    public void buildAttrA() {
        this.product.setAttributeA("buildB set attrA");
    }

    @Override
    public void buildAttrB() {
        this.product.setAttributeB("buildB set attrB");
    }

    @Override
    public void buildAttrC() {
        this.product.setAttributeC("buildB set attrC");
    }
}
