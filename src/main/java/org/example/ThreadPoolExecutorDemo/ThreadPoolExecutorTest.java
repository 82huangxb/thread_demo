package org.example.ThreadPoolExecutorDemo;

import java.util.concurrent.*;

/**
 * @author huangxb
 * @date 2023/6/13 22:33
 * @apiNote
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new ThreadPoolExecutor.DiscardOldestPolicy());
        //ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);
        threadPoolExecutor1.submit(()->{
            System.out.println("我是一个异步线程");
        });

        Future<Integer> submit = threadPoolExecutor1.submit(() -> {
            return 111;
        });
        System.out.println(submit.get());
    }
}
