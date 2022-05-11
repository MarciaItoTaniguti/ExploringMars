package elo7.marcia.challenge.model;

import java.util.List;

public class MarsPlain {
    private final Boolean[][] matrix;

    public MarsPlain(CoordinatePoint highestPoint) {
        this.matrix = new Boolean[highestPoint.getX()][highestPoint.getY()];

    }

    public void deployProbes(List<Probe> probe) {

    }

    public Boolean[][] getMatrix() {
        return matrix;
    }
}
