package com.interview.multithreading.synchronizeddemo;

/**
 * @Date: 2020/10/24 11:01
 * @Author: DengHuiLong
 * @Description:
 */
public class SynchronizedDemo {

    public void method() {
        synchronized (this) {
            System.out.println("synchronized");
        }
    }
}
