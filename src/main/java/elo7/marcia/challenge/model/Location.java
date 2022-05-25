package elo7.marcia.challenge.model;

import java.util.Objects;

public class Location {
    private int x;
    private int y;
    private Direction direction;

    public Location(int x, int y) {
        setX(x);
        setY(y);
    }
    public Location(int x, int y, Direction direction) {
        this(x, y);
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    protected Location clone() {
        return new Location(this.getX(), this.getY(), this.getDirection());
    }
}
