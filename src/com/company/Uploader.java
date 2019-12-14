package com.company;

public class Uploader extends Thread {
    private int file = 0;
    private int uploaderSpeed = 500 / 20;

    public Uploader() {
    }

    @Override
    public void run() {
        while (file < 2) {
            try {
                System.out.println("Идет загрузка 1 файла");
                sleep(uploaderSpeed * 100);
                System.out.println("1 файл загрузился");
            } catch (InterruptedException e) {
            }
            break;
        }
    }
}
