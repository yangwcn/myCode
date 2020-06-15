package designpattern.abstractfactory;

public class ConcreteProduct1 extends  Product{
    @Override
    public void methodA() {
        System.out.println("ConcreteProduct2's methodA");
    }

    @Override
    public void methodB() {
        System.out.println("ConcreteProduct2's methodB");
    }
}
