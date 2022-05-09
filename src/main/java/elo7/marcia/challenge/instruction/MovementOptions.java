package elo7.marcia.challenge.instruction;

public enum MovementOptions {
    TURN_RIGHT('R'), TURN_LEFT('L'), MOVE('M');

    private final char option;

    MovementOptions(char optionValue) {
        this.option = optionValue;
    }

    public char getOption() {
        return option;
    }

    public boolean isTurnRight() {
        return this.getOption() == TURN_RIGHT.option;
    }

}
