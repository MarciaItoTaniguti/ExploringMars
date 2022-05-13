package elo7.marcia.challenge.model.orientation;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MovementOptions {
    TURN_RIGHT('R'), TURN_LEFT('L'), MOVE('M');

    private final char option;

    MovementOptions(char optionValue) {
        this.option = optionValue;
    }

    @JsonValue
    public char getOption() {
        return option;
    }
    public boolean isTurnRight() {
        return this.getOption() == TURN_RIGHT.option;
    }
    public boolean isTurnLeft() {return this.getOption() == TURN_LEFT.option;}
    public boolean isMoveForward() {return this.getOption() == MOVE.option;}

}
