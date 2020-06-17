package designpattern.builder;

public class Client {
    public static void main(String[] args) {
        //指挥者
        Director director = new Director();
        //建造
        director.setBuilder(new ConcreteBuildA());
        //获得结果
        System.out.println(director.getProduct());
    }
    /**
     * 建造者模式和工厂模式的差异
     * 对于最后的使用者来说，工厂模式不用关系生产具体细节，只需要说我要那种东西就可以了
     * 而建造者模式类似于diy，要和老板说自己要什么类型的组件然后组装出来自己要的东西
     */
}
