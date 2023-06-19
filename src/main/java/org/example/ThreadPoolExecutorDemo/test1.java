package org.example.ThreadPoolExecutorDemo;

/**
 * @author huangxb
 * @date 2023/6/16 15:26
 * @apiNote
 */
public class test1 {

    public static int test(int a) throws InterruptedException {
        Thread.sleep(3000L);
        return a+3;
    }

    public static int test2(int a,int b) throws InterruptedException {
        Thread.sleep(2000L);
        return (a+1)+(a*b);
    }
}
