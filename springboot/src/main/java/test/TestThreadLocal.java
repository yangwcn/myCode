package test;

public class TestThreadLocal {
    public static ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> new Integer(0));

    public void initData() {
        integerThreadLocal.set(0);
    }

    public Integer getData() {
        return integerThreadLocal.get();
    }

    public void addData() {
        integerThreadLocal.set(integerThreadLocal.get() + 1);
    }

    public void removeData() {
        integerThreadLocal.remove();
    }
}
