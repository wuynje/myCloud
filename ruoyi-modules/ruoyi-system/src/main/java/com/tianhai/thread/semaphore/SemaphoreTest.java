package com.tianhai.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Author: wuynje
 * @Date: 2021/7/8 15:21
 * @Description: 信号量，控制线程同时访问的许可数，当许可数为1的时候，其实也是多线程线程安全的一种实现方式
 *
 * 应用场景举例
 * 张三、李四和王五和赵六4个人一起去饭店吃饭，不过在特殊时期洗手很重要，饭前洗手也是必须的，可是饭店只有2个洗手池，洗手池就是不能被同时使用的公共资源，这种场景就可以用到Semaphore。
 */
public class SemaphoreTest {

    public static void test(String[] args) {

        Semaphore semaphore = new Semaphore(2);//默认构造为非公平锁

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"开始洗手");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"洗手完毕");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小明").start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"开始洗手");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"洗手完毕");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小强").start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"开始洗手");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"洗手完毕");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小红").start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"开始洗手");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"洗手完毕");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小华").start();

    }


}
