package main.java.ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWork {

    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> homeWork.printA());
            executorService.execute(() -> homeWork.printB());
            executorService.execute(() -> homeWork.printC());
        }
        executorService.shutdown();
    }

    public synchronized void printA() {
        System.out.println('A');
    }

    public synchronized void printB() {
        System.out.println('B');
    }

    public synchronized void printC() {
        System.out.println('C');
    }

}
