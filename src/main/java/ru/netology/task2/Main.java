package ru.netology.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadPool =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<Integer>> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new MyCallable("Поток " + (i + 1)));
        }

        System.out.println("Выполнение всех задач.");
        List<Future<Integer>> listFuture = threadPool.invokeAll(threads);

        for (Future<Integer> future : listFuture) {
            System.out.println("Количество отправленных сообщений: " + future.get());
        }

        System.out.println("\nВыполнение самой быстрой задачи.");
        System.out.println("Количество отправленных сообщений: " + threadPool.invokeAny(threads));

        threadPool.shutdown();
    }
}
