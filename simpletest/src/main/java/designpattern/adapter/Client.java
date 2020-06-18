package designpattern.adapter;

public class Client {
    public static void main(String[] args) {
        ClassAdapter classAdapet = new ClassAdapter();
        classAdapet.method1();
        classAdapet.method2();

        System.out.println("--------------------------------");

        ObjectAdapter objectAdapter = new ObjectAdapter(new Source());
        objectAdapter.method1();
        objectAdapter.method2();

        System.out.println("--------------------------------");
        ConcreteInterfaceAdapter concreteInterfaceAdapter = new ConcreteInterfaceAdapter();
        concreteInterfaceAdapter.method1();
        concreteInterfaceAdapter.method2();
    }
    /**
     * 适配器java中为三种，类，对象，接口
     * 感觉其中的对象适配器可能更加合适实际应用场景
     * 接口适配器更适用于只实现部分方法的情况
     * 类适配器看起来更好，不过不如对象适配器灵活
     */
}
