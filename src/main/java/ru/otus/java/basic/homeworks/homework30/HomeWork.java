package main.java.ru.otus.java.basic.homeworks.homework30;

import java.util.concurrent.*;

public class HomeWork {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 5; i++) {
            Future<String> future1 = executorService.submit(new Callable<String>() {
            @Override
            public String call()  {                 
                    return ("A");
                }
            });
            Future<String> future2 = executorService.submit(new Callable<String>() {
                @Override
                public String call()  {
                    return ("B");
                }
            });
            Future<String> future3 = executorService.submit(new Callable<String>() {
                @Override
                public String call()  {
                    return ("C");
                }
            });
            
            try {
                System.out.println(future1.get());
                System.out.println(future2.get());
                System.out.println(future3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        executorService.shutdown();
    }

}
