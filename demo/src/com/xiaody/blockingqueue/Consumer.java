package com.xiaody.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xiaody on 2017/2/28.
 */
public class Consumer implements Runnable {
    private BlockingQueue<String> queue;
    private String threadName;
    private boolean isRunning = true;
    private Random random = new Random();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;


    public Consumer(BlockingQueue<String> queue, String threadName) {
        this.queue = queue;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程" + threadName + "。。。。");
        try {
            while (isRunning) {
                System.out.println(threadName + "消费者正在消费数据。。。。");
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println(threadName + "正在消费：" + data);
                    Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                } else {
                    isRunning = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出消费者线程。。。。");
        }

    }

    public void stop() {
        isRunning = false;
    }
}
