package designpattern.singleton;

public class Singleton {

    private static final Singleton singleton = new Singleton();

    Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
