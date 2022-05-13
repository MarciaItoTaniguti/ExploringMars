package elo7.marcia.challenge.model.orientation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ControllableObjectOnMatrix extends MovableObjectOnMatrix implements ListIterator<WindRose> {
    protected List<WindRose> direction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int currentIndex;

    public ControllableObjectOnMatrix(WindRose startAt) {
        setCurrentDirection(startAt);
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public int getLastIndex() {
        return direction.size()-1;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentDirection(WindRose startAt){
        direction = new ArrayList<>();
        populateRosePointList();
        currentIndex = direction.indexOf(startAt);
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    private void populateRosePointList() {
        direction = Arrays.asList(WindRose.NORTH, WindRose.EAST, WindRose.SOUTH, WindRose.WEST);
    }

    public void turnLeft() {
        this.previous();
    }

    public void turnRight() {
        this.next();
    }

    public WindRose getCurrentDirection() {
        return direction.get(currentIndex);
    }

    protected void updateDirection(MovementOptions movement) {
        if (movement.isTurnRight()) {
            this.turnRight();
        } else if (movement.isTurnLeft()) {
            this.turnLeft();
        }
    }

    protected void move() {
        switch (this.getCurrentDirection()) {
            case NORTH:
                moveUp();
                break;
            case SOUTH:
                moveDown();
                break;
            case EAST:
                moveRight();
                break;
            case WEST:
                moveLeft();
                break;
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < getLastIndex();
    }

    @Override
    public WindRose next() {
        currentIndex = hasNext() ? currentIndex+1 : 0;
        return direction.get(currentIndex);
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex != 0;
    }

    @Override
    public WindRose previous() {
        currentIndex = currentIndex==0 ? getLastIndex() : currentIndex-1;
        return direction.get(currentIndex);
    }

    @Override
    public int nextIndex() {
        return currentIndex == getLastIndex() ? 0 : currentIndex+1;
    }

    @Override
    public int previousIndex() {
        return currentIndex == 0 ? getLastIndex() : currentIndex-1;
    }

    @Override
    public void remove() {}

    @Override
    public void set(WindRose windRose) {}

    @Override
    public void add(WindRose windRose) {}
}
