package main.java.ru.otus.java.basic.homeworks.homework30;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWork {
    private final Object mon = new Object();
    private boolean stopWait = false;
    
    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork(); 
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> System.out.println('A'));
            executorService.execute(() -> System.out.println('B'));
            executorService.execute(() -> System.out.println('С'));
        }    
            executorService.shutdown();
    }
    
    
    public synchronized void printA() {
        //try {
            //synchronized (mon) {
                    //for (int i = 0; i < 5; i++) {
                        System.out.println('A');
                        /*
                        while (!stopWait) {
                            mon.wait();    
                        }                        
                         */
                        //mon.notifyAll();
                        //
                    //}
            //}
        /*
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
         */
    }

    public synchronized void printB() {
        //try {
            //synchronized (mon) {
                    //for (int i = 0; i < 5; i++) {
                        System.out.println('B');
                        /*
                        while (!stopWait) {
                            mon.wait();
                        }                        
                         */
                        //mon.notifyAll();
                        //
                    //}
            //}
        /*    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }                 
         */
    }

    public synchronized void printC() {
        //try {
            //synchronized (mon) {
                //for (int i = 0; i < 5; i++) {
                    System.out.println('C');
                    /*
                    while (!stopWait) {
                        mon.wait();
                    }
                    stopWait = true;
                    mon.notifyAll();
                    */
                //}
            //}
        /*    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
         */
    }
    
}
