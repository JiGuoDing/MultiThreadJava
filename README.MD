# ***Java基础：多线程和线程池的用法***

---


```Java
// native是一个关键字
  public static native void func() {}
// 例如 Thread 中的 sleep 方法
// 用来声明本地方法，即方法的实现并不是用 Java 编写的，
// 而是用其他语言（通常是 C 或 C++）编写的，
// 并通过 JNI（Java Native Interface，Java本地接口）与 Java 代码进行交互。
// 用来声明那些需要调用底层操作系统或硬件功能的方法。
// 这些方法的具体实现依赖于平台相关的库，而不是纯 Java 实现。
```

```Java
// Thread 类的 join() 方法用于等待线程执行完成。
// 当一个线程调用另一个线程的 join() 方法时，调用线程会被阻塞，直到被调用的线程执行结束。
// 例如：在主线程main中执行如下代码
    thread0.join();
// 在哪个线程里执行这条代码
// 就会让等待哪个线程thread0执行完毕。
```

***线程先 &nbsp;start()&nbsp; 再 &nbsp;join()***

---

***线程状态转换图***
![](./src/ThreadMap.jpg)    

### `Future` 工作机制

`Future<Type> future` `Future`是Java提供的一个接口，
表示一个 **异步任务** 的 **执行结果** 或 **状态**。  
**注**：任务的执行是异步的，也就是说主线程不会阻塞。  
`Future的作用`
- 检查任务是否完成
- 获取任务的执行结果
- 如果任务没有完成，可以阻塞等待结果

**future.get()** 方法返回 `Callable` 的 `call`
方法的返回值，如果任务未完成，会阻塞调用 `future.get()`
方法的线程去等待。 其中阻塞操作是由 `future.get()` 
方法**执行的**。

**future.isDone()** 方法检查任务是否 **已完成**。
如果已完成则返回 `true`。  

**future.isCancelled()** 方法检查任务是否 **已取消**。  

**future.cancel(boolean mayInterruptIfRunning)** 
方法取消任务的执行，如果任务已经完成或被取消，该方法会返回 `false`。
参数 `mayInterruptIfRunning` 指定是否尝试中断 **正在运行** 的任务。

#### `Future` 使用示例  
```Java
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 提交一个 Callable 任务
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Task starts...");
            Thread.sleep(2000); // 模拟耗时操作
            System.out.println("Task completed!");
            return 42;
        });

        System.out.println("Main thread continues...");

        try {
            // 获取任务结果（会阻塞直到任务完成）
            Integer result = future.get();
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executor.shutdown();
        }
    }
}

```

##### 输出示例  
```
Main thread continues...
Task starts...
Task completed!
Task result: 42
```