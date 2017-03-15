package com.xiaody.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Xiaody on 2017/2/28.
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);

        Producer producer1 = new Producer(queue,"生产者1");
        Producer producer2 = new Producer(queue,"生产者2");
        Producer producer3 = new Producer(queue,"生产者3");

        Consumer consumer = new Consumer(queue,"消费者");

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        Thread.sleep(10*1000l);
        producer1.stop();
        producer2.stop();
        producer3.stop();


        Thread.sleep(5000);

        service.shutdown();

    }
}
