package elo7.marcia.challenge.model;

import elo7.marcia.challenge.instruction.*;
import java.util.List;

public class Probe {
    private CoordinatePoint currentLocation;
    private WindRose pointsTo;

    public Probe(CoordinatePoint deployLocation, WindRose pointsTo) {
        setCurrentLocation(deployLocation);
        setPointsTo(pointsTo);
    }

    public void runInstructions(List<MovementOptions> instructions, MarsPlain mars) {
        WindRosePointController windRoseController = new WindRosePointController(pointsTo);
        for (MovementOptions currMovement:instructions) {
            MovementController movementController = new MovementController(currMovement);
            if (movementController.isToMoveForward()) {
                movementController.moveForward(windRoseController.getCurrent(), this.getCurrentLocation());
            } else {
                if (currMovement.isTurnRight()) {
                    windRoseController.turnRight();
                } else {
                    windRoseController.turnLeft();
                }
                pointsTo = windRoseController.getCurrent();
            }
        }
    }

    public CoordinatePoint getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(CoordinatePoint currentLocation) {
        this.currentLocation = currentLocation;
    }

    public WindRose getPointsTo() {
        return pointsTo;
    }

    public void setPointsTo(WindRose pointsTo) {
        this.pointsTo = pointsTo;
    }
}
