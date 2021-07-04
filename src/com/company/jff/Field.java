package com.company.jff;


import java.util.Arrays;

public class Field {
    public static final int SIZE = 7;
    public static boolean[][] DEFAULT_FIELD = {
            {true, true, true, true, true, true, false}, // month1
            {true, true, true, true, true, true, false}, // month2
            {true, true, true, true, true, true, true}, // 1-7
            {true, true, true, true, true, true, true}, // 8-14
            {true, true, true, true, true, true, true}, // 15-21
            {true, true, true, true, true, true, true}, // 22-28
            {true, true, true, false, false, false, false}, // 29-31
    };

    private boolean[][] field;

    public Field(boolean[][] field) {
        this.field = field;
    }

    public boolean canPut(boolean[][] variant, int r, int c) {
        if (r + variant.length > SIZE || c + variant[0].length > SIZE) {
            return false;
        }
        for (int i = 0; i < variant.length; i++) {
            for (int j = 0; j < variant[i].length; j++) {
                if (!variant[i][j] && !field[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean[][] put(boolean[][] variant, int r, int c) {
        boolean[][] res = getFieldClone();
        for (int i = 0; i < variant.length; i++) {
            for (int j = 0; j < variant[i].length; j++) {
                res[r + i][c + j] = variant[i][j] && field[r + i][c + j];
            }
        }
        return res;
    }

    public int getMonth() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j]) {
                    return 6 * i + j + 1;
                }
            }
        }
        return -1;
    }

    public int getDay() {
        for (int i = 2; i < SIZE; i++) {
            for (int j = 0; j < 7; j++) {
                if (field[i][j]) {
                    return SIZE * (i-2) + j + 1;
                }
            }
        }
        return -1;
    }

    public boolean[][] getFieldClone(){
        return Arrays.stream(field).map(boolean[]::clone).toArray(boolean[][]::new);
    }


}
