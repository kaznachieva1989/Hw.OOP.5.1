package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Downloaders extends Thread {
    Semaphore sem;
    private int downloaders;
    private int downloaderSpeed = 500 / 100;
    private CountDownLatch countDownLatch;

    public Downloaders(Semaphore sem, int downloaders, CountDownLatch countDownLatch) {
        this.sem = sem;
        this.downloaders = downloaders;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.printf("Пользователь       %d       скачивает файл \n", downloaders);
            sleep(downloaderSpeed * 100);
            System.out.printf("Пользователь          %d    скачал и вышел \n", downloaders);
            sem.release();
            countDownLatch.countDown();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
