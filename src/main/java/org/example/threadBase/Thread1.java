package org.example.threadBase;

/**
 * @author huangxb
 * @date 2023/6/13 15:51
 * @apiNote
 */

/**
 *@functon 多线程学习,join
 *@author 林炳文
 *@time 2015.3.9
 */
public class Thread1 extends Thread {
    private String name;
    public Thread1(String name) {
        super(name);
        this.name=name;
    }

    public void run() {
        System.out.println(java.lang.Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            //当i=3的时候，线程让步
            if(i==3){
                /**
                 * 暂停当前正在执行的线程对象，把执行机会让给相同或者更高优先级的线程。（也可能分给自己）
                 * 调用了yield()方法只是该线程回到了可运行状态等待cpu调度选中执行，而不是回到阻塞状态
                 */
                yield();
            }

            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(java.lang.Thread.currentThread().getName() + " 线程运行结束!");
    }
}




