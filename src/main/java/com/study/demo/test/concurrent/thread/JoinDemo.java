package com.study.demo.test.concurrent.thread;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread a = new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("threadA " + Thread.currentThread().getName() + "is running");
                    Thread.sleep(4500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA is done");
            }
        });

        a.start();
        Thread.sleep(100);
        synchronized (object){

            System.out.println(Thread.currentThread().getName() + " synchronized method is beginning");
            System.out.println(a.isAlive());
            Thread.sleep(2500);
            System.out.println(a.isAlive());
            System.out.println(Thread.currentThread().getName() + " is waiting");
            object.wait();
            a.join();
            System.out.println("now back to " +
                    Thread.currentThread().getName());
        }
        //join底层使用wait实现，当线程使用join不带参数时，默认join(0)。此时如果不设置时间，而且没有唤醒
        //线程对象的wait()方法运行后，可以不用其notify()方法退出，会在线程结束后，自动退出。
    }
}
