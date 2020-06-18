package designpattern.adapter;

/**
 * @author yangwei
 * @date 2020-6-18 23:29:52
 * 类适配器
 * 继承已经拥有的方法并实现目标方法
 */
public class ClassAdapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is adapter's method2");
    }
}
