package elo7.marcia.challenge.model;

public class ControllableMatrixObject extends MovableMatrixObject{
    protected MovementOptions direction;

    protected void moveForward(WindRose direction) {
        switch (direction) {
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

    public boolean isToMoveForward() {
        return direction==MovementOptions.MOVE;
    }

    public MovementOptions getDirection() {
        return direction;
    }

    public void setDirection(MovementOptions direction) {
        this.direction = direction;
    }
}
