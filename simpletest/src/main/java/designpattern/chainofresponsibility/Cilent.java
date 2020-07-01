package designpattern.chainofresponsibility;

/**
 * @author yangwei
 */
public class Cilent {
    public static void main(String[] args) {
        AbstractHandler handlerA = new ConcreteAHandler("yangw");

        AbstractHandler handlerB = new ConcreteAHandler("yangw1");
        handlerB.setHandler(handlerA);

        AbstractHandler handlerC = new ConcreteBHandler("yangw");
        handlerC.setHandler(handlerB);

        handlerC.operator();
    }
    /**
     * 责任链重点是是在当点节点有一个指向下一个节点的指针
     * 感觉类似于链表的构建遍历
     */
}
