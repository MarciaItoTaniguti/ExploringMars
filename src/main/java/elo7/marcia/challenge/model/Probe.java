package elo7.marcia.challenge.model;

import elo7.marcia.challenge.instruction.*;
import java.util.List;

public class Probe extends ControllableMatrixObject implements MoveOnMatrix{
    private WindRose pointsTo;

    public Probe(CoordinatePoint deployLocation, WindRose pointsTo) {
        setLocation(deployLocation);
        setPointsTo(pointsTo);
    }

    @Override
    public void runInstructions(List<MovementOptions> instructions, MarsPlain mars) {
        WindRosePointController windRoseController = new WindRosePointController(pointsTo);
        for (MovementOptions currMovement:instructions) {
            MovementController movementController = new MovementController(currMovement);
            pointsTo = movementController.executeOneMovement(windRoseController, location);
        }
    }

    public WindRose getPointsTo() {
        return pointsTo;
    }

    public void setPointsTo(WindRose pointsTo) {
        this.pointsTo = pointsTo;
    }
}
