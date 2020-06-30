package designpattern.chainofresponsibility;

/**
 * @author yangwei
 */
public class ConcreteAHandler extends AbstractHandler{
    private String name;

    public ConcreteAHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("ConcreteAHandler:"+ this.name + "operator");
    }
}
