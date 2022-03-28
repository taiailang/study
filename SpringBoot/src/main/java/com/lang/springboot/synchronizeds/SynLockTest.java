package com.lang.springboot.synchronizeds;

import com.lang.springboot.util.ParallelEngine;

import java.util.concurrent.ThreadPoolExecutor;

public class SynLockTest {

    private static int index = 0;


    public static void runTest() {
        ThreadPoolExecutor executor = ParallelEngine.executor;
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<100 ; i++) {
//                    synchronized(SynLockTest.class) {
                        index++;
                        System.out.println("t1:" + index);
//                    }
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ; i<100 ; i++) {
//                    synchronized(SynLockTest.class) {
                        index++;
                        System.out.println("t2:" + index);
//                    }
                }
            }
        });

//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    synchronized (SynLockTest.class) {
//                        index++;
//                        System.out.println("t1:" + index);
//                    }
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    synchronized (SynLockTest.class) {
//                        index++;
//                        System.out.println("t2:" + index);
//
//                    }
//                }
//            }
//        });
//        t1.start();
//        t2.start();
    }

    public static void main(String[] args) throws Exception {
        runTest();
        Thread.sleep(2000);
        System.out.println(index);
    }
}