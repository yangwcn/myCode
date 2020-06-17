package designpattern.simpleFactory;

/**
 * @author yangwei
 * @date 2020-6-15 14:06:06
 */
public class ProductA extends AbstractProduct {
    @Override
    protected void methodA() {
        System.out.println("ProductA 's methodA");
    }

    @Override
    protected void methodB() {
        System.out.println("ProductA 's methodB");
    }
}
