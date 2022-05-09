package elo7.marcia.challenge.model;

import elo7.marcia.challenge.instruction.CoordinatePoint;

public class MarsPlain {
    private final Boolean[][] matrix;

    public MarsPlain(CoordinatePoint highestPoint) {
        this.matrix = new Boolean[highestPoint.getX()][highestPoint.getY()];
    }

    public Boolean[][] getMatrix() {
        return matrix;
    }
}
