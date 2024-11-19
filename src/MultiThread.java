import java.util.Objects;

public class MultiThread extends Thread{
    /*
        @Override主要用于标识子类方法重写了父类或接口中的方法。
        明确意图：表明这是一个重写的方法，帮助代码阅读者理解。
        编译器校验：编译器会检查该方法是否确实重写了父类或接口中的方法。如果没有重写成功（如方法名或参数不匹配），编译器会报错。
        提高代码健壮性：避免因为拼写错误或参数不匹配导致的意外行为。

        run()方法是不需要用户来调用的，当通过start方法启动一个线程之后，当线程获得了CPU执行时间，便进入run方法体去执行具体的任务。
        注意，继承Thread类必须重写run方法，在run方法中定义具体要执行的任务。
    */
    @Override
    public void run(){
        System.out.println("线程： " + Thread.currentThread().getName() + " 正在执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程： " + Thread.currentThread().getName() + " 执行完毕");
    }

    /*
        sleep是Thread的静态本地方法
        sleep方法有两个重载
        sleep(long millis)
        sleep(long millis, int nanoseconds)
        sleep方法让线程进入阻塞状态交出CPU权限
        注意：sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。
     */

    /*
        yield方法让当前线程释放CPU权限，但不会让线程释放锁，也不会阻塞线程，而是让线程重新进入就绪状态，它只需要等待重新获取CPU执行时间
        yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会
        注意于sleep方法的区别。
     */

    /*
        join方法有三个重载
        join()
        join(long millis)
        join(long millis, int nanoseconds)
        假如在main线程中，调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。
        如果调用的是无参join方法，则等待thread执行完毕，如果调用的是指定了时间参数的join方法，则等待一定的事件。
        注意：join会让线程释放一个对象持有的锁。
     */

    /*
        wait方法会让线程进入阻塞态，并且会释放线程占有的锁，并交出CPU执行权限

     */

    /*
        interrupt 方法可以使一个处于阻塞状态的线程抛出一个异常，即中断一个正处于阻塞状态的线程。
        另外，通过 interrupt 方法配合 isInterrupted() 方法来停止正在运行的线程。
     */
    }

class MultiThreadExample{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("进入 " + Thread.currentThread().getName() + " 线程");
        MultiThread multiThread0 = new MultiThread();
        multiThread0.start();
/*
        MultiThread multiThread1 = new MultiThread();
        MultiThread multiThread2 = new MultiThread();
        MultiThread multiThread3 = new MultiThread();
*/
        System.out.println("线程 " + Thread.currentThread().getName() + " 等待");
        multiThread0.join();
        // start()用来启动一个线程，当调用start方法后，系统才会开启一个新的线程来执行用户定义的子任务，在这个过程中，会为相应的线程分配需要的资源。
        System.out.println("线程 " + Thread.currentThread().getName() + " 继续执行");
//        multiThread0.join();
/*
        multiThread1.start();
        multiThread2.start();
        multiThread3.start();
*/
    }
}

