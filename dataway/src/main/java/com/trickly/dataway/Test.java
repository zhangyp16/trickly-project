package com.trickly.dataway;

public class Test {

    private static final Object lock_1 = new Object();
    private static final Object lock_2 = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock_1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock_2){
                        System.out.println(Thread.currentThread().getName()  + "====执行");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock_2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock_1){
                        System.out.println(Thread.currentThread().getName()  + "====执行");
                    }
                }
            }
        }).start();
    }
}
