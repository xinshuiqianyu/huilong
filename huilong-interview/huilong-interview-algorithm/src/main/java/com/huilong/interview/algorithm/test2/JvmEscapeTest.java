package com.huilong.interview.algorithm.test2;

/**
 * @Date: 2021/3/18 12:54
 * @Author: DengHuiLong
 * @Description:
 */
public class JvmEscapeTest {

    static class Admin {
        public String name;
    }

    public static void testEscape() {
        Admin admin = new Admin();
    }

    public static void main(String[] args) {
        System.out.println("start");
        long begin = System.currentTimeMillis();
        for (long i = 0; i < 1000000; i++) {
            testEscape();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
