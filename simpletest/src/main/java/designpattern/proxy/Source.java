package designpattern.proxy;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("Source's method");
    }
}
