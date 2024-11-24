import java.util.concurrent.*;

/**
 * 计算前n个自然数的平方和
 */
public class CallableDemo implements Callable<Integer> {
    private final Integer n;

     public CallableDemo(Integer n) {
         this.n = n;
     }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("第 " + i + " 个自然数正由线程 " + Thread.currentThread().getName() + "计算");
            sum += i * i;
            // 模拟任务耗时
            Thread.sleep(100);
            System.out.println("前 " + i + " 个自然数已计算完成");
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo(100);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交任务并获取 Future 对象
        Future<Integer> future = executorService.submit(callableDemo);
        System.out.println("任务提交完毕");

        // 使用 Future 获取结果（会阻塞直到任务完成）
        Integer result = future.get();
        System.out.println("前n个自然数的平方和为：" + result);

        // 关闭线程池
        executorService.shutdown();
    }
}
