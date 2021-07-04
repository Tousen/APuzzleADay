package com.company.jff.figures;

public class F8 implements IFigure {
    protected boolean variations[][][] = {
            //001
            //111
            //100
            {
                    {true, true, false},
                    {false, false, false},
                    {false, true, true},
            },
            {
                    {false, false, true},
                    {true, false, true},
                    {true, false, false},
            },
            //flip
            {
                    {false, true, true},
                    {false, false, false},
                    {true, true, false},
            },
            {
                    {true, false, false},
                    {true, false, true},
                    {false, false, true},
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
        return '@';
    }
}
