package ru.otus.java.basic.homeworks.homework21;

public class HomeWork {
    private static final int ARRAY_SIZE = 100_000_000;

    public static void main(String[] args) {
        double[] doubleArray = new double[ARRAY_SIZE];
        System.out.printf("Запускаем заполнение массива в %s элементов значениями. Ожидайте...\n", ARRAY_SIZE);
        long timeToFillArray = fillArrayPartOnTime(doubleArray, 0, ARRAY_SIZE - 1);
        System.out.printf("Время заполнения массива в одном main thread : %s ms.\n", timeToFillArray);

        Thread t1 = threadToFillQuarterOfArray(doubleArray, 0);
        Thread t2 = threadToFillQuarterOfArray(doubleArray, 1);
        Thread t3 = threadToFillQuarterOfArray(doubleArray, 2);
        Thread t4 = threadToFillQuarterOfArray(doubleArray, 3);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private static Thread threadToFillQuarterOfArray(double[] doubleArr, int quarterIndex) {
        int quarterArraySize = Math.round((float) doubleArr.length / 4);
        return new Thread(() -> {
            long timeToFill = fillArrayPartOnTime(doubleArr, quarterArraySize * quarterIndex, quarterArraySize * (quarterIndex + 1) - 1);
            System.out.printf("Время заполнения четверти массива в thread_%s: %s ms.\n", quarterIndex + 1, timeToFill);
        });
    }

    private static long fillArrayPartOnTime(double[] doubleArr, int fromIndex, int toIndex) {
        long startTime = System.currentTimeMillis();
        for (int i = fromIndex; i <= toIndex; i++) {
            doubleArr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
