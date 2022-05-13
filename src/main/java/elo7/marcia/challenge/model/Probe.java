package elo7.marcia.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import elo7.marcia.challenge.model.orientation.ControllableObjectOnMatrix;
import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import elo7.marcia.challenge.model.orientation.MovementOptions;
import elo7.marcia.challenge.model.orientation.WindRose;
import elo7.marcia.challenge.model.planet.MarsSurface;

import java.util.List;

public class Probe extends ControllableObjectOnMatrix {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final List<MovementOptions> instructions;

    public Probe(CoordinatePoint deployLocation, WindRose pointsTo, List<MovementOptions> instructions) {
        super(pointsTo);
        this.instructions = instructions;
        setLocation(deployLocation);
    }

    public void runInstructions(MarsSurface mars) {
        for (MovementOptions currMovement:instructions) {
            Probe lastProbe = new Probe(new CoordinatePoint(this.getLocation().getX(), this.getLocation().getY()), this.getCurrentDirection(), this.getInstructions());
            if (currMovement.isMoveForward()) {
                this.move();
            } else {
                updateDirection(currMovement);
            }
            try {
                mars.updateProbeOnMatrix(this, lastProbe);
            } catch (Exception e) {
                this.setLocation(lastProbe.getLocation());
                return;
            }
        }
    }

    public List<MovementOptions> getInstructions() {
        return instructions;
    }
}
