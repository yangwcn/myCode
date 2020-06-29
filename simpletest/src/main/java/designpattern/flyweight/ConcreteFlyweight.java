package designpattern.flyweight;

public class ConcreteFlyweight extends Flyweight {
    ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate() {
        System.out.println("ConcreteFlyweight's operate" + getIntrinsic() + extrinsic + this.hashCode());
    }
}
