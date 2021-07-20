package ru.netology.task3;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    public static final int LENGTH_OF_SUB = 10_000;

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
        final int diff = end - start;
        int sum = 0;
        if (diff < LENGTH_OF_SUB) {
            for (int i = 0; i < diff; i++) {
                sum += array[start + i];
            }
            return sum;
        } else {
            return forkTasksAndGetResult();
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
