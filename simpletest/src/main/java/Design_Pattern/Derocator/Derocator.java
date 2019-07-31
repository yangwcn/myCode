package Design_Pattern.Derocator;

public abstract class Derocator extends Source{
    Source s = null;
    public Derocator(Source s) {
        this.s = s;
    }
    public void operate(){
        this.s.operate();
    }
}
