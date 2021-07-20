package ru.netology.task2;

import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    private static final int NUMBER_OF_MESSAGE = 3;

    public MyCallable(String name) {
        super(name);
    }

    @Override
    public Integer call() {
        for (int i = 0; i < NUMBER_OF_MESSAGE; i++) {
            System.out.println("Я " + getName());
        }
        return NUMBER_OF_MESSAGE;
    }
}
