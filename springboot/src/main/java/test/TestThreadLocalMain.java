package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocalMain {
    // 创建线程池
    private static ExecutorService executor = Executors
            .newCachedThreadPool();

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.addData();
        testThreadLocal.addData();
        executor.submit(new Runnable() {
            public void run() {
                TestThreadLocal testThreadLocal = new TestThreadLocal();
                //testThreadLocal.initData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                System.out.println("Thread1 value = " + testThreadLocal.getData());
                System.out.println(System.currentTimeMillis());
                testThreadLocal.removeData();
            }
        });
        executor.submit(new Runnable() {
            public void run() {
                TestThreadLocal testThreadLocal = new TestThreadLocal();
                //testThreadLocal.initData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                System.out.println("Thread2 value = " + testThreadLocal.getData());
                System.out.println(System.currentTimeMillis());
                testThreadLocal.removeData();
            }
        });
        try {
            Thread.sleep(700);
        } catch (Exception e){
            e.printStackTrace();
        }
        executor.submit(new Runnable() {
            public void run() {
                TestThreadLocal testThreadLocal = new TestThreadLocal();
                //testThreadLocal.initData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                testThreadLocal.addData();
                System.out.println("Thread3 value = " + testThreadLocal.getData());
                System.out.println(System.currentTimeMillis());
            }
        });
        System.out.println("Thread1 value = " + testThreadLocal.getData());
    }
}
