package elo7.marcia.challenge.model;

public abstract class Movable {
    private Location location;

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    protected Movable clone() {
        return new Probe(this.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movable)) return false;
        Movable movable = (Movable) o;
        return movable.getLocation().getY()==this.getLocation().getY() &&
                movable.getLocation().getX()==this.getLocation().getX() &&
                movable.getLocation().getDirection().equals(this.getLocation().getDirection());
    }

    protected abstract void moveObjectUp(Planet mars) throws Exception;
    protected abstract void moveObjectDown(Planet mars) throws Exception;
    protected abstract void moveObjectLeft(Planet mars) throws Exception;
    protected abstract void moveObjectRight(Planet mars) throws Exception;
    protected abstract void turnRight(Planet mars) throws Exception;
    protected abstract void turnLeft(Planet mars) throws Exception;
}
