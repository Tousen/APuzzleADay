package com.company.jff;

import com.company.jff.figures.IFigure;

import java.util.Objects;

public class Position {
    public int x;
    public int y;
    public int variant;
    public IFigure figure;

    public Position(int x, int y, int variant, IFigure figure) {
        this.x = x;
        this.y = y;
        this.variant = variant;
        this.figure = figure;
    }

    public boolean isOccupying(int x, int y) {
        int posX = x - this.x;
        int posY = y - this.y;
        boolean[][] variant = figure.getFigureByIndex(this.variant);
        return posX >= 0 && posY >= 0 && posX < variant.length && posY < variant[0].length && !variant[posX][posY];
    }

    public Position clone(){
        return new Position(x, y, variant,figure);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && variant == position.variant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, variant);
    }
}
