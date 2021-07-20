package ru.netology.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new MyThread(threadGroup, "Поток " + (i + 1)));
        }

        threads.forEach(Thread::start);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException ignore) { }

        System.out.println("Завершаю все потоки");
        threadGroup.interrupt();
    }
}
