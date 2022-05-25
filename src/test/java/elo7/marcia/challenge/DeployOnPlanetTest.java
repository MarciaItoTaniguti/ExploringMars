package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeployOnPlanetTest {

    @Test
    void executeTestSuccess() throws Exception {
        Location location = new Location(0,1, Direction.N);
        Probe probe = new Probe(location);
        Planet mars = new Planet(3,3);
        probe.deploy(mars);

        List<Movable> marsProbes = mars.getMovableList();
        assertEquals(new Probe(location),marsProbes.get(0));
    }

    @Test
    void executeTestFailOutOfBoundsNegative() throws Exception {
        Location location = new Location(-1,1, Direction.N);
        Probe probe = new Probe(location);
        Planet mars = new Planet(3,3);

        Exception exception = assertThrows(
                Exception.class,
                () -> probe.deploy(mars));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void executeTestFailOutOfBoundsPositive() throws Exception {
        Location location = new Location(100,1, Direction.N);
        Probe probe = new Probe(location);
        Planet mars = new Planet(3,3);

        Exception exception = assertThrows(
                Exception.class,
                () -> probe.deploy(mars));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void executeTestFailOnNotEmptySpace() throws Exception {
        Location location = new Location(1,1,Direction.N);
        Probe probe = new Probe(location);
        Planet mars = new Planet(3,3);
        probe.deploy(mars);

        Probe probe2 = new Probe(location);
        Exception exception = assertThrows(
                Exception.class,
                () -> probe2.deploy(mars));

        assertTrue(exception.getMessage().contains(Planet.INVALID_LOCALE));
    }


}
