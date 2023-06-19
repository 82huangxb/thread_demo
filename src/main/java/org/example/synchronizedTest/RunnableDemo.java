package org.example.synchronizedTest;

/**
 * @author huangxb
 * @date 2023/6/16 15:00
 * @apiNote
 */
public class RunnableDemo implements Runnable{

    private Integer ticket = 100;

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //进来之前需要上锁
            synchronized (this){
                if (ticket <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖了第" + ticket + "张票");
                ticket--;
            }
        }
    }
}
