package Design_Pattern.Derocator;

public class Client {
    public static void main(String[] args) {
        Source s = new Source();
        s = new ConcreteDerocator1(s);
        s = new ConcreteDerocator2(s);
        s.operate();
    }
}
