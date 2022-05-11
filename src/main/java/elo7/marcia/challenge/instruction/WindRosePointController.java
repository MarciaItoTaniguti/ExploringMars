package elo7.marcia.challenge.instruction;

import elo7.marcia.challenge.model.WindRose;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class WindRosePointController implements ListIterator<WindRose> {
    private List<WindRose> list;
    private final int lastIndex;
    private int currentIndex;

    public WindRosePointController(WindRose startAt) {
        list = new ArrayList<>();
        populateRosePointList();
        currentIndex = list.indexOf(startAt);
        lastIndex = list.size()-1;
    }

    private void populateRosePointList() {
        list = Arrays.asList(WindRose.NORTH, WindRose.EAST, WindRose.SOUTH, WindRose.WEST);
    }

    public void turnLeft() {
        this.previous();
    }

    public void turnRight() {
        this.next();
    }

    public WindRose getCurrent() {
        return list.get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < lastIndex;
    }

    @Override
    public WindRose next() {
        currentIndex = hasNext() ? currentIndex+1 : 0;
        return list.get(currentIndex);
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex != 0;
    }

    @Override
    public WindRose previous() {
        currentIndex = currentIndex==0 ? lastIndex : currentIndex-1;
        return list.get(currentIndex);
    }

    @Override
    public int nextIndex() {
        return currentIndex == lastIndex ? 0 : currentIndex+1;
    }

    @Override
    public int previousIndex() {
        return currentIndex == 0 ? lastIndex : currentIndex-1;
    }

    @Override
    public void remove() {}

    @Override
    public void set(WindRose windRose) {}

    @Override
    public void add(WindRose windRose) {}
}