package com.company.jff;

import com.company.jff.figures.*;

import java.io.IOException;
import java.util.Arrays;

import static com.company.jff.Field.SIZE;

public class Solver implements Runnable {

    Calendar calendar;
    int si;
    int sj;

    public Solver(Calendar calendar, int si, int sj) {
        this.calendar = calendar;
        this.si = si;
        this.sj = sj;
    }


    public void solve(IFigure[] figuresLeft, Solution solution) {
        if (figuresLeft.length == 0) {
            if (solution.isValidDate()) {
                calendar.addSolution(solution.getMonthIndex(), solution.getDayIndex(), solution.getClone());
            }
            return;
        }
        Field field = solution.getField();
        IFigure[] left = Arrays.copyOfRange(figuresLeft, 1, figuresLeft.length);
        IFigure figure = figuresLeft[0];
        // dumb thread divider
        boolean isTopDepth = figuresLeft.length == 8;
        int si = isTopDepth ? this.si : 0;
        int ei = isTopDepth ? si + 1 : SIZE;
        int sj = isTopDepth ? this.sj : 0;
        int ej = isTopDepth ? sj + 1 : SIZE;

        for (int r = 0; r < figure.getVariantsCount(); r++) {
            boolean[][] variant = figure.getFigureByIndex(r);
            for (int i = si; i < ei; i++) {
                for (int j = sj; j < ej; j++) {
                    if (field.canPut(variant, i, j)) {
                        Field newField = new Field(field.put(variant, i, j));
                        solution.addPosition(new Position(i, j, r, figure), 8 - figuresLeft.length);
                        solution.setField(newField);
                        solve(left, solution);
                    }
                }
            }
        }
        return;
    }


    @Override
    public void run() {
        Solution solution = new Solution();
        solution.setField(new Field(Field.DEFAULT_FIELD));
        solve(new IFigure[]{new F1(), new F2(), new F3(), new F4(), new F5(), new F6(), new F7(), new F8()}, solution);
    }
}
