package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import elo7.marcia.challenge.model.orientation.MovementOptions;
import elo7.marcia.challenge.model.orientation.ObjectOnMatrix;
import elo7.marcia.challenge.model.orientation.WindRose;
import elo7.marcia.challenge.model.planet.MarsSurface;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarsPlainTest {

    @Test
    void testDeployProbeSuccess() throws Exception{
        MarsSurface mars = new MarsSurface(new CoordinatePoint(4,4));

        CoordinatePoint deployLocation = new CoordinatePoint(3,3);
        WindRose direction = WindRose.EAST;
        ObjectOnMatrix probe = new Probe(deployLocation,direction, null);
        mars.deployProbe(probe);

        assertEquals(new Probe(deployLocation, direction, null), mars.getObjectsOnMatrix().get(0));
    }

    @Test
    void testUpdateProbeOnMatrixSuccess() throws Exception{
        MarsSurface mars = new MarsSurface(new CoordinatePoint(4,4));
        CoordinatePoint deployLocation = new CoordinatePoint(3,3);
        WindRose directionOld = WindRose.EAST;
        List<MovementOptions> instructionsOld = Lists.newArrayList(MovementOptions.TURN_RIGHT, MovementOptions.MOVE);
        Probe probeOld = new Probe(deployLocation,directionOld,instructionsOld);
        WindRose direction = WindRose.NORTH;
        List<MovementOptions> instructions = Lists.newArrayList(MovementOptions.TURN_RIGHT, MovementOptions.MOVE);
        Probe probe = new Probe(deployLocation,direction,instructions);
        mars.deployProbe(probe);


        assertEquals(mars.getObjectsOnMatrix().size(), 1);
        assertDoesNotThrow(() ->
                mars.updateProbeOnMatrix(probe,probeOld));
        assertEquals(mars.getObjectsOnMatrix().size(), 1);
    }
}
