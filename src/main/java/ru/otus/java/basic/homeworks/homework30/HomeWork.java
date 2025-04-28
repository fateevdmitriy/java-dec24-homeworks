package main.java.ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.*;

public class HomeWork {
    private int counter = 0;
    private final Object mon = new Object();
    
    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> homeWork.printChar('A'));
        executorService.execute(() -> homeWork.printChar('B'));
        executorService.execute(() -> homeWork.printChar('C'));
        executorService.shutdown();
    }
    
    public void printChar(char symbol) {
        synchronized (mon) {
            int orderCnt = Character.toUpperCase(symbol) - 'A';
            try {
                for (int i = 0; i < 5; i++) {
                    while (counter != i * 3 + orderCnt) {
                        mon.wait();
                     }
                    System.out.println(symbol);
                    counter++;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
