package com.huilong.interview.algorithm.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Date: 2021/4/10 19:35
 * @Author: DengHuiLong
 * @Description: 3 个线程交替打印 1-100 的整数
 */
public class ThreadPrintDemo {
    // 存放线程的集合
    private static List<Thread> threads = new ArrayList<>();
    // 线程数
    private static int threadSize = 3;
    // 当前线程下标
    private static int threadIndex = 0;
    // 需要输出的最大值
    private static int maxValue = 100;
    // 数的当前值
    private static int curValue = 1;

    public static void main(String[] args) {
        for (int i = 1; i <= threadSize; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    // 阻塞当前线程
                    LockSupport.park();
                    if (curValue <= maxValue) {
                        System.out.println(Thread.currentThread().getName() + ": " + curValue++);
                    } else {
                        break;
                    }
                    // 唤起下一个线程
                    LockSupport.unpark(threads.get(++threadIndex % threadSize));
                }
                // 唤起所有线程
                threads.forEach(LockSupport::unpark);
            });
            thread.setName(String.format("Thread%d", i));
            threads.add(thread);
        }
        // 启动所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        // 唤起第一个线程
        LockSupport.unpark(threads.get(0));
    }
}
