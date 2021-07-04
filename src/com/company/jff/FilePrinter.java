package com.company.jff;

import java.io.*;
import java.util.List;

import static com.company.jff.Calendar.DAYS;
import static com.company.jff.Calendar.MONTHS;
import static com.company.jff.Field.SIZE;

public class FilePrinter {
    private FileWriter writer;

    public FilePrinter() {
        try {
            writer = new FileWriter("out.txt");
        } catch (IOException notFoundException) {
            System.out.println("file not found error");
        }
    }

    public void printSolution(Solution solution) throws IOException {
        writer.write(solution.getDate() + "\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(getChar(i, j, solution));
            }
            sb.append("\n");
        }

        writer.write(sb.toString());
    }

    public void printSolutions(List<Solution> solutions) throws IOException {
        System.out.println(solutions.size());
        solutions.forEach(solution -> {
            try {
                printSolution(solution);
            } catch (IOException e) {
                System.err.println("solution print failed");
            }
        });
    }

    public void printSolutions(Calendar calendar) throws IOException {
        for (int i = 0; i < MONTHS; i++) {
            for (int j = 0; j < DAYS; j++) {
                printSolutions(calendar.getSolutionList(i, j));
            }
        }

    }

    public char getChar(int i, int j, Solution solution) {
        for (int pos = 0; pos < 8; pos++) {
            Position position = solution.getPosition(pos);
            if (position.isOccupying(i, j)) {
                return position.figure.getId();
            }
        }
        return ' ';
    }

    public void end() throws IOException {
        writer.close();
    }
}
