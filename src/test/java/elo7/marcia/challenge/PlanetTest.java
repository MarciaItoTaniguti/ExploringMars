package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetTest {
    @Test
    void executeTestFail() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Planet(-3,3));

        assertTrue(exception.getMessage().contains(Planet.INVALID_BORD));
    }

    @Test
    void moveObjectUpTestSuccess() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,0);
        planet.addObject(location, probe);
        planet.moveObjectUp(probe);

        assertNotNull(planet.getObjects().get(new Location(0,1)));
    }

    @Test
    void moveObjectUpTestFail() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(3,3);
        planet.addObject(location, probe);

        Exception exception = assertThrows(
                Exception.class,
                () -> planet.moveObjectUp(probe));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void moveObjectDownTestSuccess() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,1);
        planet.addObject(location, probe);
        planet.moveObjectDown(probe);

        assertNotNull(planet.getObjects().get(new Location(0,0)));
    }

    @Test
    void moveObjectDownTestFail() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,0);
        planet.addObject(location, probe);

        Exception exception = assertThrows(
                Exception.class,
                () -> planet.moveObjectDown(probe));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void moveObjectRightTestSuccess() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,0);
        planet.addObject(location, probe);
        planet.moveObjectRight(probe);

        assertNotNull(planet.getObjects().get(new Location(1,0)));
    }

    @Test
    void moveObjectRightTestFail() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(3,3);
        planet.addObject(location, probe);

        Exception exception = assertThrows(
                Exception.class,
                () -> planet.moveObjectRight(probe));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void moveObjectLeftTestSuccess() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(1,0);
        planet.addObject(location, probe);
        planet.moveObjectLeft(probe);

        assertNotNull(planet.getObjects().get(new Location(0,0)));
    }

    @Test
    void moveObjectLeftTestFail() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,0);
        planet.addObject(location, probe);

        Exception exception = assertThrows(
                Exception.class,
                () -> planet.moveObjectLeft(probe));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }

    @Test
    void turnRightTest() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(1,0, Direction.E);
        planet.addObject(location, probe);
        planet.turnRight(probe);

        assertNotNull(planet.getObjects().get(new Location(1,0, Direction.S)));
    }

    @Test
    void turnLeftTest() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(1,0, Direction.S);
        planet.addObject(location, probe);
        planet.turnLeft(probe);

        assertNotNull(planet.getObjects().get(new Location(1,0, Direction.W)));
    }

    @Test
    void moveForwardTestSuccess() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,1, Direction.S);
        planet.addObject(location, probe);
        planet.moveForward(probe);

        assertNotNull(planet.getObjects().get(new Location(0,0, Direction.S)));
    }

    @Test
    void moveForwardTestFail() throws Exception {
        Probe probe = new Probe();
        Planet planet = new Planet(3,3);
        Location location = new Location(0,0, Direction.S);
        planet.addObject(location, probe);

        Exception exception = assertThrows(
                Exception.class,
                () -> planet.moveForward(probe));

        assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
    }
}
