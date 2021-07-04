package com.company.jff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.company.jff.Field.SIZE;

public class Main {

    public static void main(String[] args) throws IOException {
        Calendar calendar = new Calendar();
        List<Callable<Object>> threads = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                threads.add(Executors.callable(new Solver(calendar, i, j)));
            }
        }
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            es.invokeAll(threads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
        FilePrinter printer = new FilePrinter();
        printer.printSolutions(calendar);
        printer.end();
    }
}
