package designpattern.derocator;

public class ConcreteDerocator2 extends Derocator {
    public ConcreteDerocator2(Source s) {
        super(s);
    }

    private void Derocatormethod2() {
        System.out.println("Derocatormethod2");
    }

    @Override
    public void operate() {
        this.Derocatormethod2();
        super.operate();
    }
}
