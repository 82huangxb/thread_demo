package org.example.ThreadPoolExecutorDemo;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.example.ThreadPoolExecutorDemo.test1.test;
import static org.example.ThreadPoolExecutorDemo.test1.test2;

/**
 * @author huangxb
 * @date 2023/6/13 22:33
 * @apiNote
 *
 * CountDownLatch: 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 * CyclicBarrier : N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。关键点其实就在于那N个线程
 * （1）CountDownLatch里面N个线程就是学生，学生做完了试卷就可以走了，不用等待其他的学生是否完成
 * （2）CyclicBarrier 里面N个线程就是所有的游戏玩家，一个游戏玩家加载到100%还不可以，必须要等到其他的游戏玩家都加载到100%才可以开局
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        /**
         * CountDownLatch(int count)：count为计数器的初始值（一般需要多少个线程执行，count就设为几）
         */
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new ThreadPoolExecutor.DiscardOldestPolicy());
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.DiscardOldestPolicy());

        threadPoolExecutor.execute(()->{
            System.out.println("我是没有返回值的");
            countDownLatch.countDown();
        });
        Future<Integer> submit1 = threadPoolExecutor.submit(() -> {
            int a = test(3);
            //countDown(): 每调用一次计数器值-1，直到count被减为0，代表所有线程全部执行完毕。
            System.out.println(a);
            countDownLatch.countDown();
            return a;
        });

        Future<Integer> submit = threadPoolExecutor.submit(() -> {
            int test = test2(4, 5);
            System.out.println(test);
            countDownLatch.countDown();
            return test;
        });



        /**
         * await(): 等待计数器变为0，即等待所有异步线程执行完毕。
         * 主线程等待所有子线程操作结束 才能开始后面操作
         */
        countDownLatch.await();

        /**
         *  threadPoolExecutor.shutdown(); // 设置线程池的状态为SHUTDOWN，然后中断所有没有正在执行任务的线程
         *  threadPoolExecutor.shutdownNow(); // 设置线程池的状态为 STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表
         */
        // 关闭线程池
        threadPoolExecutor.shutdown();

        //获取所有子线程返回值
        Integer integer = submit.get();
        Integer integer1 = submit1.get();
        int a = integer+integer1;
        System.out.println(a);
        System.out.println("主线程最后执行");
    }
}
