package designpattern.chainofresponsibility;

/**
 * @author yangwei
 */
public class ConcreteBHandler extends AbstractHandler{
    private String name;

    public ConcreteBHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("ConcreteBHandler:"+ this.name + "operator");
        if(null != this.getHandler()) {
            this.getHandler().operator();
        }
    }
}
