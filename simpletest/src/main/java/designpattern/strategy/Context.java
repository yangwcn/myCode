package designpattern.strategy;

public class Context {
    private Strategy strategy = null;

    public Context(Strategy s) {
        this.strategy = s;
    }

    public void doanything() {
        System.out.println("doanything");
        this.strategy.dosomeing();
    }
}
