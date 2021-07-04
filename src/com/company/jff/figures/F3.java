package com.company.jff.figures;

public class F3 implements IFigure {
    protected boolean variations[][][] = {
            //0100
            //1111
            //rotations
            {
                    {true, false, true, true},
                    {false, false, false, false},
            },
            {
                    {true, false},
                    {true, false},
                    {false, false},
                    {true, false},
            },
            {
                    {false, false, false, false},
                    {true, true, false, true},
            },
            {
                    {false, true},
                    {false, false},
                    {false, true},
                    {false, true},
            },
            //flip
            {
                    {true, true, false, true},
                    {false, false, false, false},
            },
            {
                    {false, true},
                    {false, true},
                    {false, false},
                    {false, true},
            },
            {
                    {false, false, false, false},
                    {true, false, true, true},
            },
            {
                    {true, false},
                    {false, false},
                    {true, false},
                    {true, false},
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
        return '#';
    }
}
