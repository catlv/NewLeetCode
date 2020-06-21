package 手写;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * 手写一个线程池
 */
public class ThreadPool {
    private static volatile int i = 0; //加 volatile 没用，它并不能保证原子性

    private static synchronized void increase() {
        //此处加上 Synchronized 可以解决问题，成功返回20000
        //这里加了 Synchronized 后就前面的 i 位置就不需要加 volatile 了
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = newCachedThreadPool();
        Runnable r = () -> {
            for (int j = 0; j < 10000; j++) {
                increase();
            }
        };
        e.execute(r);
        e.execute(r);
        Thread.sleep(1000);
        e.shutdown();
        System.out.println(i);
    }
}

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 1000; j++) {
//                    increase();
//                }
//            }
//        };