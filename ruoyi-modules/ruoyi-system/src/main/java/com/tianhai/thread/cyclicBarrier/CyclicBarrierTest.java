package com.tianhai.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: wuynje
 * @Date: 2021/7/7 17:18
 * @Description:倒计数器升级版 CyclicBarrier【循环栅栏】,也是用来阻塞线程
 * 但是CountDownLatch是倒计数，CyclicBarrier是等到最后一个线程调用await()方法被阻塞，才会终止阻塞
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
        try {
//            TimeUnit.SECONDS.sleep(4000);
            System.out.println("所有线程都已经准备好了>>>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    });//当4个线程都await的时候才会执行

    public static void test(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println("线程 "+Thread.currentThread().getName()+" 已经准备好了。");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        // 查询当前等待的线程数量，如果不为0，则主线程继续等待
        while (cyclicBarrier.getNumberWaiting()!=0){
            Thread.sleep(1000);
        }
        //当CyclicBarrier的parties较小的时候，比如3，会发生瞬间所有线程全部await的情况，会导致下面的这段话先输出
        System.out.println("=== 线程准备好了，程序运行结束 ===");
    }

}
