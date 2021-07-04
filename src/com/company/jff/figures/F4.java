package com.company.jff.figures;

public class F4 implements IFigure {
    protected boolean variations[][][] = {
            //0011
            //1110
            //rotations
            {
                    {true, true, false, false},
                    {false, false, false, true},
            },
            {
                    {false, true},
                    {false, false},
                    {true, false},
                    {true, false},
            },
            {
                    {true, false, false, false},
                    {false, false, true, true},
            },
            {
                    {false, true},
                    {false, true},
                    {false, false},
                    {true, false},
            },
            //flip
            {
                    {false, false, true, true},
                    {true, false, false, false},
            },
            {
                    {true, false},
                    {false, false},
                    {false, true},
                    {false, true},
            },
            {
                    {false, false, false, true},
                    {true, true, false, false},
            },
            {
                    {true, false},
                    {true, false},
                    {false, false},
                    {false, true},
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
        return '&';
    }
}
