package designpattern.simpleFactory;

/**
 * @author yangwei
 * @date 2020-6-15 14:09:00
 */
public class ProductFactory {
    /**
     * 工厂创建
     * @param type
     * @return
     */
    public static AbstractProduct creatProduce(String type) {
        AbstractProduct abstractProduct;
        if("A".equals(type)) {
            abstractProduct = new ProductA();
        } else {
            abstractProduct = new ProductB();
        }
        abstractProduct.methodA();
        abstractProduct.methodB();
        return abstractProduct;
    }
}
