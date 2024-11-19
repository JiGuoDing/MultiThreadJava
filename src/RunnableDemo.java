public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("this is runnableDemo " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }
}
