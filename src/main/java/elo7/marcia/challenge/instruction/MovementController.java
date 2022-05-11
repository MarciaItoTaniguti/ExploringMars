package elo7.marcia.challenge.instruction;

import elo7.marcia.challenge.model.CoordinatePoint;
import elo7.marcia.challenge.model.MovementOptions;
import elo7.marcia.challenge.model.WindRose;

public class MovementController {
    private final MovementOptions option;

    public MovementController(MovementOptions option) {
        this.option = option;
    }

    public WindRose executeOneMovement(WindRosePointController windRoseController, CoordinatePoint currentLocation) {
        if (isToMoveForward()) {
            moveForward(windRoseController.getCurrent(), currentLocation);
        } else {
            if (option.isTurnRight()) {
                windRoseController.turnRight();
            } else {
                windRoseController.turnLeft();
            }
        }
        return windRoseController.getCurrent();
    }

    public boolean isToMoveForward() {
        return option==MovementOptions.MOVE;
    }

    public void moveForward(WindRose direction, CoordinatePoint location) {
        switch (direction) {
            case NORTH:
                moveUp(location);
                break;
            case SOUTH:
                moveDown(location);
                break;
            case EAST:
                moveRight(location);
                break;
            case WEST:
                moveLeft(location);
                break;
        }
    }

    private void moveLeft(CoordinatePoint location) {
        location.setX(location.getX()-1);
    }

    private void moveRight(CoordinatePoint location) {
        location.setX(location.getX()+1);
    }

    private void moveUp(CoordinatePoint location) {
        location.setY(location.getY()+1);
    }

    private void moveDown(CoordinatePoint location) {
        location.setY(location.getY()-1);
    }

}
