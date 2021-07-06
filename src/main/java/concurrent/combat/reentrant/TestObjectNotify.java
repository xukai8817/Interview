package concurrent.combat.reentrant;

/**
 * @author xukai
 * @since 2021/7/5 14:59
 */
public class TestObjectNotify {

    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("thread1");
        Thread2 thread2 = new Thread2("thread2");

        thread1.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }

    static class Thread1 extends Thread {

        private String name;

        public Thread1(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread {

        private String name;

        public Thread2(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了object.notify()");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
        }
    }
}
