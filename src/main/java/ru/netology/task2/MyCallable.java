package ru.netology.task2;

import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    private int numberOfMessage = 3;

    public MyCallable(String name, int numberOfMessage) {
        super(name);
        this.numberOfMessage = numberOfMessage;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < numberOfMessage; i++) {
            System.out.println("Я " + getName());
        }
        return numberOfMessage;
    }
}
