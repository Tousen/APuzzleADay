package com.company.jff;

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    private Position[] positions = new Position[8];
    private Field field;

    public Solution() {

    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void addPosition(Position position, int index) {
        this.positions[index] = position;
    }

    public Position getPosition(int index){
        return this.positions[index];
    }

    public String getDate() {
        int month = field.getMonth();
        int day = field.getDay();
        return month + " " + day;
    }

    public boolean isValidDate() {
        int month = field.getMonth();
        int day = field.getDay();
        return day > 0 && month > 0;
    }

    public int getMonthIndex() {
        return field.getMonth() - 1;
    }

    public int getDayIndex() {
        return field.getDay() - 1;
    }

    public Solution getClone(){
        Solution clone = new Solution();
        clone.setField(new Field(this.field.getFieldClone()));
        for(int i=0;i<8;i++){
            clone.addPosition(getPosition(i).clone(), i);
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Arrays.equals(positions, solution.positions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(positions);
    }
}
