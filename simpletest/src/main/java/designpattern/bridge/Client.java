package designpattern.bridge;

public class Client {
    public static void main(String[] args) {
        ConcreteBridge concreteBridge = new ConcreteBridge(new Source1());
        concreteBridge.operate();

        ConcreteBridge concreteBridge2 = new ConcreteBridge(new Source2());
        concreteBridge2.operate();
    }
    /**
     * 将抽象化与实现化解耦，使得二者可以独立变化
     * 感觉java中这种还是挺多的
     */
}
