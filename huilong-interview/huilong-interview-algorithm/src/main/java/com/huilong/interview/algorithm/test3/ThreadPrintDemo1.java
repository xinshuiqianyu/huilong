package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Date: 2021/4/10 20:46
 * @Author: DengHuiLong
 * @Description: 多线程有序循环打印
 */
public class ThreadPrintDemo1 {

    private static List<Thread> threads = new ArrayList<>();
    private static int threadSize = 3;
    private static int threadIndex = 0;
    private static int numberMax = 100;
    private static int numberIndex = 1;

    public static void main(String[] arg) {
        for (int i = 1; i <= threadSize; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    LockSupport.park();
                    if (numberIndex <= numberMax) {
                        System.out.println(Thread.currentThread().getName() + ": " + numberIndex++);
                    } else {
                        break;
                    }
                    LockSupport.unpark(threads.get(++threadIndex % threadSize));
                }
                threads.forEach(LockSupport::unpark);
            });
            thread.setName(String.format("Thread%d", i));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        LockSupport.unpark(threads.get(0));
    }

}
