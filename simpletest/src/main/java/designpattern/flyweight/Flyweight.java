package designpattern.flyweight;

public abstract class Flyweight {
    private String intrinsic;
    protected final String extrinsic;

    Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

    public abstract void operate();
}
