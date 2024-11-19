public class EasyThread {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("线程 " + Thread.currentThread().getName() + " 开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程 " + Thread.currentThread().getName() + " 执行完成");
        }, "Thread-JGD").start();
    }
}
