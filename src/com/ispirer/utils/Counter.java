package com.ispirer.utils;

public class Counter {
    private int id;
    private static int count = 0;

    public Counter() {
        this.count++;
        this.id = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Counter.count = count;
    }
}
