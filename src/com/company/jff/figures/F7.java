package com.company.jff.figures;

public class F7 implements IFigure{
    protected boolean variations[][][] = {
            {
                    {false, true, false},
                    {false, false, false},
            },
            {
                    {false, false},
                    {false, true},
                    {false, false},
            },
            {
                    {false, false, false},
                    {false, true, false},
            },
            {
                    {false, false},
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
        return '=';
    }
}
