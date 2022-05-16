package elo7.marcia.challenge.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import elo7.marcia.challenge.model.Direction;

public class ExploreMarsProbe {
    private int locationX;
    private int locationY;
    private Direction direction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String instructions;

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
