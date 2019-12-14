package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Uploader uploader = new Uploader();
        uploader.start();
        synchronized (uploader) {
            uploader.wait();
        }
        Semaphore sem = new Semaphore(3, true);
        for (int i = 1; i <= 10; i++) {
            new Downloaders(sem, i).start();
        }
    }
}

