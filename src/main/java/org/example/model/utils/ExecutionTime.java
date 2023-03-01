package org.example.model.utils;

import java.util.function.Consumer;

public class ExecutionTime {
    public static void checkTime(Runnable func) {
        System.out.println("func start:");
        long millis = System.currentTimeMillis();
        func.run();
        millis = System.currentTimeMillis() - millis;
        System.out.println("func end:\n\ttime: " + millis / 1000.0 + "s");
    }
}
