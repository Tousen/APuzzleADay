package com.company.jff;

import java.util.LinkedList;
import java.util.List;

public class Calendar {
    public static final int MONTHS = 12;
    public static final int DAYS = 31;

    List<Solution>[][] calendar = new LinkedList[MONTHS][DAYS];

    public Calendar() {
        for (int i = 0; i < MONTHS; i++) {
            for (int j = 0; j < DAYS; j++) {
                calendar[i][j] = new LinkedList<>();
            }
        }
    }

    public void addSolution(int month, int day, Solution solution) {
        calendar[month][day].add(solution);
    }

    public List<Solution> getSolutionList(int month, int day) {
        return calendar[month][day].stream().distinct().toList();
    }
}
