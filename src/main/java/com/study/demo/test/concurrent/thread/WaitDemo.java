package com.study.demo.test.concurrent.thread;


public class WaitDemo {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        c.setName("c线程");
        b.setName("b线程");
        c.start();
        System.out.println(Thread.currentThread().getName() + "is start....");
        //主线程sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (c) {
//            try {
//                System.out.println(Thread.currentThread().getName() + " synchronized method is beginning");
//                System.out.println(c.isAlive());
//                Thread.sleep(1000);
//                System.out.println(c.isAlive());
//                System.out.println(Thread.currentThread().getName() + " is waiting");
//                //等待c线程执行完，唤醒
//                c.wait();
//                System.out.println("now back to " +
////                        Thread.currentThread().getName());
//                b.start();
//            } catch (InterruptedException e) {
//            }
        }
    }
}

class ThreadB extends Thread {
    int total;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running..");
        synchronized (this) {

            for (int i = 0; i < 10; i++) {
                total += i;
            }
            System.out.println("total is " + total);
        }
    }
}

class ThreadC extends Thread {
    //private Person person;
    int sum = 1;

    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running..");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " synchronized method is beginning");
            for (int i = 1; i < 10; i++) {
                sum *= i;
            }
            System.out.println(Thread.currentThread().getName() + " synchronized method is ending");
//            notify();
        }
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("c线程运行结束");
    }
}