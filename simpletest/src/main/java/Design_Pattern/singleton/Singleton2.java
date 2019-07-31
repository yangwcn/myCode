package Design_Pattern.singleton;

public class Singleton2 {
    private static volatile Singleton2 singleton2;

    Singleton2() {}

    public Singleton2 getInstance() {

        if(singleton2 == null) {
            synchronized(Singleton2.class) {
                if(singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
