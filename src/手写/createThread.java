package 手写;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 详细版创建线程的四种方式。
 * 现场手写采用 MyThread 里的简洁版
 */
public class createThread {

    //方法一：继承 Thread
    public static class create1 extends Thread {
        private int i;

        @Override
        public void run() {
            for (; i < 100; i++) {
                System.out.println(getName() + "" + i);
            }
        }
    }

    //方法二：实现 Runnable
    public static class create2 implements Runnable {
        private int i;

        @Override
        public void run() {
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "" + i);
            }
        }
    }

    //方法三：实现 Callable
    public static class create3 implements Callable<Integer> {
        private int i;

        @Override
        public Integer call() {
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "" + i);
            }
            return i;
        }
    }

    //测试
    public static void main(String[] args) {
        new create1().start();

        create2 c2 = new create2();
        new Thread(c2, "Thread2-").start();

        create3 c3 = new create3();
        FutureTask<Integer> ft = new FutureTask<>(c3);
        new Thread(ft, "Thread3-").start();

        //方法四：线程池
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        });
        e.shutdown();

        //execute 没有返回值
        //submit  有返回值，返回一个Future类型的对象

//        e.execute(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + "-" + i);
//                }
//            }
//        });
//
//        Runnable r = () -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName() + "-" + i);
//            }
//        };
//        e.execute(r);
//        e.submit(r);
//        e.shutdown();
    }
}
