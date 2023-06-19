package org.example.synchronizedTest;

/**
 * @author huangxb
 * @date 2023/6/16 15:02
 * @apiNote
 */
public class MainDemo {
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread threadA = new Thread(runnableDemo,"a");
        Thread threadB = new Thread(runnableDemo,"b");
        Thread threadC = new Thread(runnableDemo,"c");
        Thread threadD = new Thread(runnableDemo,"d");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
