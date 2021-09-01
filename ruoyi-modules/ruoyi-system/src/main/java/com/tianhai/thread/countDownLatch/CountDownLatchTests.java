package com.tianhai.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: CountDownLatch 闭锁
 * @author: stone
 * @date: Created by 2021/6/21 17:04
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.springmybatis.thread
 */
public class CountDownLatchTests {

    //教练>>>>>>>>>>>>>>>>
    private static CountDownLatch commanderCd  = new CountDownLatch(1);
    //三个运动员
    private static CountDownLatch sportsman = new CountDownLatch(3);

    public static void test(String[] args) throws Exception{
        testCountDownLatch();
    }

    public static void testCountDownLatch() throws Exception {
        new Thread(() -> {
            try {
                commanderCd.await();
                System.out.println(Thread.currentThread().getName() + "=========>开始跑了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sportsman.countDown();
                System.out.println(Thread.currentThread().getName() + "=========>达到终点");

            }


        },"小明").start();

        new Thread(() -> {
            try {
                commanderCd.await();
                System.out.println(Thread.currentThread().getName() + "=========>开始跑了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sportsman.countDown();
                System.out.println(Thread.currentThread().getName() + "=========>达到终点");

            }


        },"小红").start();

        new Thread(() -> {
            try {
                commanderCd.await();
                System.out.println(Thread.currentThread().getName() + "=========>开始跑了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sportsman.countDown();
                System.out.println(Thread.currentThread().getName() + "=========>达到终点");

            }


        }, "小武").start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("预备===============>");
        commanderCd.countDown();
        sportsman.await();
        System.out.println("所以的运动员都跑完===============================>");

    }
}
