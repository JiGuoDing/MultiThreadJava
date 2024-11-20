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

