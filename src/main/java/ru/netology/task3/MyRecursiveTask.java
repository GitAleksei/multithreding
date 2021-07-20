package ru.netology.task3;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    final int[] array;
    int start;
    int end;

    public MyRecursiveTask(int start, int end, int[] array) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignore) {

        }
        final int diff = end - start;
        switch (diff) {
            case 0: return 0;
            case 1: return array[start];
            case 2: return array[start] + array[start + 1];
            default: return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;

        MyRecursiveTask task1 = new MyRecursiveTask(start, middle, array);

        MyRecursiveTask task2 = new MyRecursiveTask(middle, end, array);

        invokeAll(task1, task2);

        return task1.join() + task2.join();
    }
}
