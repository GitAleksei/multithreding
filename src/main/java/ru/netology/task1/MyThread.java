package ru.netology.task1;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.println("Я " + getName() + ", мой id = " + getId());
            }
        } catch (InterruptedException ignored) {

        } finally {
            System.out.printf("%s завершен\n", getName());
        }
    }
}
