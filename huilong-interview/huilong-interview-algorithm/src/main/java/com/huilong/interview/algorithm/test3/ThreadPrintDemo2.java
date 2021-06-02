package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Date: 2021/5/7 21:46
 * @Author: DengHuiLong
 * @Description: 三个线程交替打印 1-100
 */
public class ThreadPrintDemo2 {

    private static List<Thread> threads = new ArrayList<>();
    private static int threadSize = 3;
    private static int threadIndex = 0;
    private static int maxValue = 100;
    private static int valueIndex = 1;

    public static void main(String[] args) {
        for (int i = 1; i <= threadSize; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    LockSupport.park();
                    if (valueIndex <= maxValue) {
                        System.out.println(Thread.currentThread().getName() + ": " + valueIndex++);
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
