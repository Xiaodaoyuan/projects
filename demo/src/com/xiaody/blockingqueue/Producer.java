package com.xiaody.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Xiaody on 2017/2/28.
 */
public class Producer implements Runnable {
    private BlockingQueue<String> queue;
    private String threadName;
    private boolean isRunning = true;
    private Random random = new Random();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue<String> queue, String threadName) {
        this.queue = queue;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        String data;
        System.out.println("启动生产者线程" + threadName + "。。。。");
        try {
            while (isRunning) {
                System.out.println(threadName + "正在生产数据。。。。");
                Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                data = "data:" + count.incrementAndGet();
                System.out.println(threadName + "将数据：" + data + "放入队列...");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println(threadName + "放入数据失败：" + data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出生产者线程");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
