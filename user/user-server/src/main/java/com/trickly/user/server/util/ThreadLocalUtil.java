package com.trickly.user.server.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalUtil {

    static final ThreadLocal<String> threadParam = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadParam.set("abc");
        //固定池内只有存活3个线程
        ExecutorService execService = Executors.newFixedThreadPool(3);
        //死循环几次才能看出效果
        while (true) {
            Thread t = new Thread(()->{
                threadParam.set("abcd");
                System.out.println("t1:" + threadParam.get());
                //如果不调用remove,将引发问题
                 threadParam.remove();
            });
            execService.execute(t);
            TimeUnit.SECONDS.sleep(1);
            Thread t2 = new Thread(()-> {
                System.out.println("t2:" + threadParam.get());
            });
            execService.execute(t2);
        }
    }
}
