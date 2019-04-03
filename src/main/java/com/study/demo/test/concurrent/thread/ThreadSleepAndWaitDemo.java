package com.study.demo.test.concurrent.thread;

public class ThreadSleepAndWaitDemo {

    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //当前线程不包含当前对象的锁资源  java.lang.IllegalMonitorStateException
                synchronized (object){
                try {
                    System.out.println("thread" + Thread.currentThread().getName() + " is running");
//                    Thread.sleep(1000);
                    wait(1000);
                    System.out.println("thread"+Thread.currentThread().getName()+" is done");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (object){
                System.out.println("thread"+Thread.currentThread().getName()+" is running");
            }
        });

        t1.start();
        t2.start();

    }
}
