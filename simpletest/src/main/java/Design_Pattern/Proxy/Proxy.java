package Design_Pattern.Proxy;

public class Proxy implements Sourceable{
    private Source source;

    public Proxy(Source source){
        this.source = source;
    }

    @Override
    public void method() {
        this.source.method();
    }


}
