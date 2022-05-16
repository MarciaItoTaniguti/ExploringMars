package elo7.marcia.challenge.model;

public interface MoveObjectInterface {
    void moveObjectUp(Object object) throws Exception;

    void moveObjectDown(Object object) throws Exception;

    void moveObjectLeft(Object object) throws Exception;

    void moveObjectRight(Object object) throws Exception;

    void turnRight(Object object);

    void turnLeft(Object object);

    void moveForward(Object object) throws Exception;
}
