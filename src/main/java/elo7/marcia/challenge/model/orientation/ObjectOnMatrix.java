package elo7.marcia.challenge.model.orientation;

import java.util.Objects;

public class ObjectOnMatrix {
    protected CoordinatePoint location;

    public CoordinatePoint getLocation() {
        return location;
    }

    public void setLocation(CoordinatePoint location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectOnMatrix)) return false;
        ObjectOnMatrix that = (ObjectOnMatrix) o;
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
