package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String,Flyweight> flyweightMsp = new HashMap<>();

    public static Flyweight getFlyweight(String extrinsic) {

        if(flyweightMsp.containsKey(extrinsic)) {
            return flyweightMsp.get(extrinsic);
        } else {
            Flyweight f = new ConcreteFlyweight(extrinsic);
            flyweightMsp.put(extrinsic,f);
            return f;
        }
    }
}
