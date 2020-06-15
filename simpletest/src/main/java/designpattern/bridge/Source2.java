package designpattern.bridge;

public class Source2 implements Sourceable {
    @Override
    public void method1() {
        System.out.println("Source2's method1");
    }

    @Override
    public void method2() {
        System.out.println("Source2's method2");
    }
}
