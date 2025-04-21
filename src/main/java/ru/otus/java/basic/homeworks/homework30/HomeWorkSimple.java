package main.java.ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWorkSimple {
    
    public static void main(String[] args) {
        HomeWorkSimple homeWorkSimple = new HomeWorkSimple();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> homeWorkSimple.printA());
            executorService.execute(() -> homeWorkSimple.printB());
            executorService.execute(() -> homeWorkSimple.printC());
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
