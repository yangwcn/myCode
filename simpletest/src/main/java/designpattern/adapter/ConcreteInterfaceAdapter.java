package designpattern.adapter;

/**
 * @author yangwe
 * @date 2020-6-18 23:52:50
 * 具体实现类
 * 可以定义实现的内容
 */
public class ConcreteInterfaceAdapter extends AbstractAdapter {
    @Override
    public void method2() {
        System.out.println("ConcreteInterfaceAdapter's method2");
    }
}
