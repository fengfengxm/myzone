package com.imgeek.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class WaitingQueueTest {
    WaitingQueue<Integer> waitingQueue = new WaitingQueue<>();

    @Test
    public void demoShow() {
        int NUM = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        for (int i = 0; i < NUM; i++) {
            MyThread myThread = new MyThread(
                    () -> {
                        waitingQueue.push(1);
                        waitingQueue.push(1);
                        waitingQueue.pop();
                    }
            );
            myThread.setCountDownLatch(countDownLatch);
            myThread.setWaitingQueue(waitingQueue);
            myThread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(waitingQueue.size(), NUM);
    }
}