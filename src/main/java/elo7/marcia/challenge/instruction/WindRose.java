package elo7.marcia.challenge.instruction;

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
