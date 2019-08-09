package drools;

import lombok.Data;

@Data
public class Product {
    /**
     * 钻石
     */
    public static final String DIAMOND = "0";

    /**
     * 黄金
     */
    public static final String GOLD = "1";

    private String type;

    private int discount;
}
