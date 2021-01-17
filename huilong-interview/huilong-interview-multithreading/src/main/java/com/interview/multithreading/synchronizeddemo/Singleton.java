package com.interview.multithreading.synchronizeddemo;

/**
 * @Date: 2020/10/24 10:44
 * @Author: DengHuiLong
 * @Description: 双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public synchronized static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    /**
                     * 1、为 uniqueInstance 分配内存空间
                     * 2、初始化 uniqueInstance
                     * 3、将 uniqueInstance 指向分配的内存地址
                     */
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

