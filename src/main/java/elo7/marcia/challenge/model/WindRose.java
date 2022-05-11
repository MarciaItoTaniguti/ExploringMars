package elo7.marcia.challenge.model;

public enum WindRose {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private final char direction;

    WindRose(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }


}
