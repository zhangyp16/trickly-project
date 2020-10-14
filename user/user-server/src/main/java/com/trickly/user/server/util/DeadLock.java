package com.trickly.user.server.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeadLock {

    public static void main(String[] args) throws Exception {
        // deadLock();
        oom();
    }


    private static void oom() throws InterruptedException {
        List<int[]> bigObj = new ArrayList();

        for (int i = 0; i < 1000; ++i) {
            /*if (i == 0) {
                Thread.sleep(500L);
                System.out.println("start = [" + new Date() + "]");
            } else {
                Thread.sleep(4000L);
            }*/
            bigObj.add(new int[524288 * 4]);
        }
    }

    private static void deadLock(){
        Object o1 = new Object(), o2 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println(Thread.currentThread().getName() + "=====>");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println(Thread.currentThread().getName() + "=====>");
                    }
                }
            }
        }).start();
    }
}
