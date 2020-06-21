package 手写;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyThread {
    //方法一：继承 Thread
    public static class MyThread1 extends Thread {

        @Override
        public void run() {
            //...
        }
    }

    //方法二：实现 Runnable
    public static class MyThread2 implements Runnable {

        @Override
        public void run() {
            //...
        }
    }

    //方法三：实现 Callable
    public static class MyThread3 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 123;
        }
    }

    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        m1.start();

        MyThread2 m2 = new MyThread2();
        Thread t2 = new Thread(m2);
        t2.start();

        MyThread3 m3 = new MyThread3();
        FutureTask<Integer> ft = new FutureTask<>(m3);
        Thread t3 = new Thread(ft);
        t3.start();

        //方法四：线程池
        ExecutorService e = Executors.newCachedThreadPool();
        //lambda表达式
        e.execute(() -> {
            //...
        });
        e.shutdown();

        e.execute(new Runnable() {
            @Override
            public void run() {
                //...
            }
        });
    }
}
