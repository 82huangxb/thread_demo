package org.example.threadBase;

/**
 * @author huangxb
 * @date 2023/6/13 15:51
 * @apiNote
 */

import static java.lang.Thread.sleep;

/**
 *@functon 多线程学习,join
 *@author 林炳文
 *@time 2015.3.9
 */
public class ThreadRunnable implements Runnable{
    private String name;
    public ThreadRunnable(String name) {
        this.name=name;
    }

    public void run() {
        System.out.println(name + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                //使线程转为阻塞状态
                sleep((int) (Math.random() * 10));
                //sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " 线程运行结束!");
    }
}




