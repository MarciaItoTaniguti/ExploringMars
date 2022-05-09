package elo7.marcia.challenge;

import elo7.marcia.challenge.instruction.CoordinatePoint;
import elo7.marcia.challenge.instruction.CoordinatePointOnMatrix;
import elo7.marcia.challenge.instruction.MovementOptions;
import elo7.marcia.challenge.instruction.WindRose;
import elo7.marcia.challenge.model.Probe;

import java.util.ArrayList;
import java.util.List;

public class ProbeBuilder {

    public static Probe generateProbeOne() {
        CoordinatePoint deployAt = new CoordinatePointOnMatrix(3,3);
        return new Probe(deployAt, WindRose.EAST);
    }

    public static List<MovementOptions> getInstructionForProbeOne() {
        List<MovementOptions> exploreInstructions = new ArrayList<>();
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_RIGHT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_RIGHT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_RIGHT);
        exploreInstructions.add(MovementOptions.TURN_RIGHT);
        exploreInstructions.add(MovementOptions.MOVE);
        return exploreInstructions;
    }

    public static Probe generateProbeTwo() {
        CoordinatePoint deployAt = new CoordinatePointOnMatrix(1,2);
        return new Probe(deployAt, WindRose.NORTH);
    }

    public static List<MovementOptions> getInstructionForProbeTwo() {
        List<MovementOptions> exploreInstructions = new ArrayList<>();
        exploreInstructions.add(MovementOptions.TURN_LEFT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_LEFT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_LEFT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.TURN_LEFT);
        exploreInstructions.add(MovementOptions.MOVE);
        exploreInstructions.add(MovementOptions.MOVE);
        return exploreInstructions;
    }

}
