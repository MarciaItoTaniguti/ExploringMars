package elo7.marcia.challenge.model.orientation;

import java.util.Objects;
import java.lang.Object;

public class CoordinatePoint {
    private int x;
    private int y;

    public CoordinatePoint(){}

    public CoordinatePoint(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinatePoint)) return false;
        CoordinatePoint that = (CoordinatePoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
