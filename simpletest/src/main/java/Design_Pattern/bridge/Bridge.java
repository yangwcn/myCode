package Design_Pattern.bridge;

public abstract class Bridge {
    private Sourceable sourceable;
    public Bridge(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public abstract void operate();

    public Sourceable getSourceable() {
        return this.sourceable;
    }

    public  void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }
}
