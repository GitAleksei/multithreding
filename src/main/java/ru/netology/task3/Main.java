package ru.netology.task3;


import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final int LENGTH_OF_ARRAY = 1_000_000;
    private static final int SEED = 1_000;

    public static void main(String[] args) {
        int[] array = getRandomArray(LENGTH_OF_ARRAY, SEED);
        System.out.println("Подсчет суммы и среднего значения массива.");
        System.out.println("Без пула потоков.");
        Instant start = Instant.now();
        long sum = calcSumArray(array);
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + sum / LENGTH_OF_ARRAY);
        Instant finnish = Instant.now();
        System.out.println("Время выполнения, мс: " + Duration.between(start, finnish).toMillis());

        System.out.println("\nForkJoinPool: ");
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(0, array.length, array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        start = Instant.now();
        sum = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + sum / LENGTH_OF_ARRAY);
        finnish = Instant.now();
        System.out.println("Время выполнения, мс: " + Duration.between(start, finnish).toMillis());

    }


    private static long calcSumArray(int[] array) {
        long sum = 0;
        for (int a : array) {
            sum += a;
        }

        return sum;
    }

    private static int[] getRandomArray(int length, int seed) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(seed);
        }

        return array;
    }
}
