package elo7.marcia.challenge.instruction;

public class MovementController {
    private final MovementOptions option;

    public MovementController(MovementOptions option) {
        this.option = option;
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
