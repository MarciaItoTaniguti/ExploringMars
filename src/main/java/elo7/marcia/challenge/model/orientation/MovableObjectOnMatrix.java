package elo7.marcia.challenge.model.orientation;

public class MovableObjectOnMatrix extends ObjectOnMatrix {

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
