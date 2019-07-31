package Design_Pattern.bridge;

public class Source1 implements Sourceable {
    @Override
    public void method1() {
        System.out.println("Source1's method1");
    }

    @Override
    public void method2() {
        System.out.println("Source1's method2");
    }
}
