package Design_Pattern.Adapter;

public class Adapet extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is Adapter's method2");
    }
}
