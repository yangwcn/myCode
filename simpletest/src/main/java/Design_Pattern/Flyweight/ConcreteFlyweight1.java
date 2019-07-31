package Design_Pattern.Flyweight;

public class ConcreteFlyweight1 extends Flyweight {
    ConcreteFlyweight1(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate() {
        System.out.println("ConcreteFlyweight1's operate");
    }
}
