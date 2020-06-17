package designpattern.derocator;

public class ConcreteDerocator1 extends Derocator{
    public ConcreteDerocator1(Source s) {
        super(s);
    }

    public void derocatorMethod1(){
        System.out.println("DerocatorMethod1");
    }

    @Override
    public void operate() {
        this.derocatorMethod1();
        super.operate();
    }
}
