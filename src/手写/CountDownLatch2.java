package 手写;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch 的使用案例
 */
public class CountDownLatch2 {
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 100;
        AtomicInteger count = new AtomicInteger();
        CountDownLatch cdl = new CountDownLatch(threadSize);
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            e.execute(() -> {
                count.getAndIncrement();
                cdl.countDown();
            });
        }
        cdl.await();
        e.shutdown();
        System.out.println(count.get()); //总是最后输出100
    }
}
