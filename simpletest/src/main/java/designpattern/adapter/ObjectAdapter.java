package designpattern.adapter;

/**
 * @author yangwei
 * @date 2020-6-18 23:34:59
 * 对象适配器
 */
public class ObjectAdapter implements Targetable{
    private Source source;

    public ObjectAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("ObjectAdapet's method2");
    }
}
