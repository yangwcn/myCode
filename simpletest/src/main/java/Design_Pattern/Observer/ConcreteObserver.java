package Design_Pattern.Observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Concrete's update");
    }
}
