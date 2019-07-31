package test;

public class TestPrint implements Runnable{
    private int type;

    public TestPrint(int type) {
        this.type = type;
    }

    public void run() {
        while(true) {
            synchronized (TestPrint.class) {
                try {
                    TestPrint.class.notifyAll();
                    TestPrint.class.wait();
                    if (type == 0) {
                        System.out.println((int) Math.random() * 10);
                    } else {
                        System.out.println((char) (int) (Math.random() * 26 + 'A'));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread nthread = new Thread(new TestPrint(0));
        Thread zthread = new Thread(new TestPrint(1));

        nthread.start();
        zthread.start();
    }

}
