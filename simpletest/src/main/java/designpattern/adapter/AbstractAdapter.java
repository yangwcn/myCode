package designpattern.adapter;

/**
 * @author yangwei
 * @date 2020-6-18 23:51:28
 * 抽象类继承接口
 */
public abstract class AbstractAdapter implements Targetable {
    @Override
    public void method1() {
        System.out.println("AbstractAdapter's method1, do nothing");
    }

    @Override
    public void method2() {

    }
}
