package org.example.threadBase;

/**
 * @author huangxb
 * @date ${DATE} ${TIME}
 * @apiNote
 * ②join():指等待t线程终止。
 * 使用方式：
 * join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，
 * 这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，
 * 只有等到子线程结束了才能执行。
 *======================================================
 *在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，
 * 主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，
 * 需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
            System.out.println(Thread1.currentThread().getName()+"主线程运行开始!");
            ThreadRunnable mTh1=new ThreadRunnable("R");
            Thread threadR = new Thread(mTh1);
            Thread threadT = new Thread1("T");
            //设置线程优先级
            threadR.setPriority(Thread.MAX_PRIORITY);
            //线程进入运行状态
            threadT.start();
            threadR.start();
            //threadR.join();  //子线程让步，主线程必须等待子线程调用完成才能调用（使线程进入阻塞状态）
            //threadT.join();   //子线程让步，主线程必须等待子线程调用完成才能调用（使线程进入阻塞状态）
            System.out.println(Thread1.currentThread().getName()+ "主线程运行结束!");
    }
}