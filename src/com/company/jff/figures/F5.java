package com.company.jff.figures;

public class F5 implements IFigure {
    protected boolean variations[][][] = {
            //0001
            //1111
            //rotations
            {
                    {true, true, true, false},
                    {false, false, false, false},
            },
            {
                    {false, false},
                    {true, false},
                    {true, false},
                    {true, false},
            },
            {
                    {false, false, false, false},
                    {false, true, true, true},
            },
            {
                    {false, true},
                    {false, true},
                    {false, true},
                    {false, false},
            },
            //flip
            {
                    {false, true, true, true},
                    {false, false, false, false},
            },
            {
                    {false, false},
                    {false, true},
                    {false, true},
                    {false, true},
            },
            {
                    {false, false, false, false},
                    {true, true, true, false},
            },
            {
                    {true, false},
                    {true, false},
                    {true, false},
                    {false, false},
            },
    };

    @Override
    public boolean[][] getFigureByIndex(int rotation) {
        return this.variations[rotation];
    }

    @Override
    public int getVariantsCount() {
        return this.variations.length;
    }
    @Override
    public char getId() {
        return '$';
    }
}
