import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // 创建一个大小固定为3的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交5个任务到线程池
        for (int i = 0; i < 6; i++){
            int taskNum = i;
            executorService.execute(() -> {
                System.out.println("任务 " + taskNum + " 正由线程 " + Thread.currentThread().getName() + " 执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("任务 " + taskNum + " 执行完成");
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
