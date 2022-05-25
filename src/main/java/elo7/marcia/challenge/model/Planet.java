package elo7.marcia.challenge.model;

import java.util.*;

public class Planet {
    private int borderX;
    private int borderY;
    private final List<Movable> movableList;
    public static final String OUT_OF_BORD = "Movement out of board.";
    public static final String INVALID_BORD = "Invalid bord value.";
    public static final String INVALID_LOCALE = "Invalid deploy location";

    public Planet(int borderX, int borderY) throws Exception {
        setBorderX(borderX);
        setBorderY(borderY);
        this.movableList = new ArrayList<>();
    }

    protected void addMovable(Movable movable) throws Exception {
        validateMovableLocation(movable.getLocation());
        validateMovableOnEmptySpace(movable.getLocation());
        movableList.add(movable);
    }

    private void validateMovableLocation(Location location) throws Exception {
        if (location.getX() < 0 || location.getY() < 0 || location.getX() > this.getBorderX() || location.getY() > this.getBorderY()) {
            throw new Exception(OUT_OF_BORD);
        }
    }

    private void validateMovableOnEmptySpace(Location location) throws Exception {
        boolean isOccupied = movableList.stream().anyMatch(s -> s.getLocation().equals(location));
        if (isOccupied) {
            throw new Exception(INVALID_LOCALE);
        }
    }

    protected void updateMovable(Movable movable, TargetLocation targetLocation) throws Exception {
        Movable originalMovable = movable.clone();
        movableList.remove(movable);
        movable.setLocation(targetLocation);
        try {
            addMovable(movable);
        } catch (Exception ex) {
            movableList.add(originalMovable);
            throw ex;
        }
    }

    private void setBorderX(int x) throws Exception {
        if (x < 0) {
            throw new Exception(INVALID_BORD);
        }
        this.borderX = x;
    }

    private void setBorderY(int y) throws Exception {
        if (y < 0) {
            throw new Exception(INVALID_BORD);
        }
        this.borderY = y;
    }

    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public List<Movable> getMovableList() {
        return Collections.unmodifiableList(movableList);
    }
}
