package elo7.marcia.challenge.model.orientation;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WindRose {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private final char direction;

    @JsonValue
    public char getDirection() {
        return direction;
    }
    WindRose(char direction) {
        this.direction = direction;
    }
}
