package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeployOnPlanetTest {

    @Test
    void executeTestSuccess() throws Exception {
        Location location = new Location(0,1, Direction.N);
        Probe probe = new Probe();
        Planet mars = new Planet(3,3);

        DeployOnPlanet.execute(location, probe, mars);
        assertNotNull(mars.getObjects().get(location));
    }

    @Test
    void executeTestFailOutOfBoundsNegative() throws Exception {
        Location location = new Location(-1,1, Direction.N);
        Probe probe = new Probe();
        Planet mars = new Planet(3,3);

        Exception exception = assertThrows(
                Exception.class,
                () -> DeployOnPlanet.execute(location, probe, mars));

        assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
    }

    @Test
    void executeTestFailOutOfBoundsPositive() throws Exception {
        Location location = new Location(100,1, Direction.N);
        Probe probe = new Probe();
        Planet mars = new Planet(3,3);

        Exception exception = assertThrows(
                Exception.class,
                () -> DeployOnPlanet.execute(location, probe, mars));

        assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
    }

    @Test
    void executeTestFailOnNotEmptySpace() throws Exception {
        Probe probe = new Probe();
        Planet mars = new Planet(3,3);
        Location location = new Location(1,1,Direction.N);
        DeployOnPlanet.execute(location, probe, mars);

        Probe probe2 = new Probe();
        Exception exception = assertThrows(
                Exception.class,
                () -> DeployOnPlanet.execute(location, probe2, mars));

        assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
    }


}
