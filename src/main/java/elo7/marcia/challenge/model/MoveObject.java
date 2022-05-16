package elo7.marcia.challenge.model;

public class MoveObject {

    protected static void moveUp(MoveObjectInterface surface, Object object) throws Exception {
        surface.moveObjectUp(object);
    }

    protected static void moveDown(MoveObjectInterface surface, Object object) throws Exception {
        surface.moveObjectDown(object);
    }

    protected static void moveRight(MoveObjectInterface surface, Object object) throws Exception {
        surface.moveObjectRight(object);
    }

    protected static void moveLeft(MoveObjectInterface surface, Object object) throws Exception {
          surface.moveObjectLeft(object);
    }

    protected static void turnRight(MoveObjectInterface surface, Object object) {
        surface.turnRight(object);
    }

    protected static void turnLeft(MoveObjectInterface surface, Object object) {
        surface.turnLeft(object);
    }

    protected static void moveForward(MoveObjectInterface surface, Object object) throws Exception {
        surface.moveForward(object);
    }

    protected static <V> void validateMovement(V value) throws Exception {
        if (value != null){
            throw new Exception("Occupied Location");
        }
    }

}
