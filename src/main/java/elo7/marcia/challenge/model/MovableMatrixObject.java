package elo7.marcia.challenge.model;

public class MovableMatrixObject extends MatrixObject {

    protected void moveUp() {
        location.setY(location.getY()+1);
    }

    protected void moveRight() {
        location.setX(location.getX()+1);
    }

    protected void moveDown() {
        location.setY(location.getY()-1);
    }

    protected void moveLeft() {
        location.setX(location.getX()-1);
    }
}
