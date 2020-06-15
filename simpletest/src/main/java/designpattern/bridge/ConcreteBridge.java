package designpattern.bridge;

public class ConcreteBridge extends Bridge {
    public ConcreteBridge(Sourceable sourceable) {
        super(sourceable);
    }
    @Override
    public void operate() {
        this.getSourceable().method1();
        this.getSourceable().method2();
    }
}
