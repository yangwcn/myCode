package designpattern.simpleFactory;

/**
 * @author yangwei
 * @date 2020-6-15 14:06:06
 */
public class ProductB extends AbstractProduct {
    @Override
    protected void methodA() {
        System.out.println("ProductB 's methodA");
    }

    @Override
    protected void methodB() {
        System.out.println("ProductB 's methodB");
    }
}
