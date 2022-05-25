package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PlanetTest {
    @Test
    void addMovableSuccess() throws Exception {
        Planet mars = new Planet(5,5);

        Location locationProbe1 = new Location(1,2, Direction.N);
        Probe probe = new Probe(locationProbe1);
        probe.deploy(mars);
        Location locationProbe2 = new Location(1,3, Direction.N);
        Probe probe2 = new Probe(locationProbe2);
        probe2.deploy(mars);

        List<Movable> marsProbes = mars.getMovableList();
        assertEquals(new Probe(locationProbe1), marsProbes.get(0));
        assertEquals(new Probe(locationProbe2), marsProbes.get(1));
    }

    @Test
    void addMovableFail() throws Exception {
        Planet mars = new Planet(5,5);

        Probe probe = new Probe(new Location(1,2, Direction.N));
        probe.deploy(mars);
        Probe probe2 = new Probe(new Location(1,2, Direction.S));

        Exception exception = assertThrows(
                Exception.class,
                () ->  probe2.deploy(mars));

        assertTrue(exception.getMessage().contains(Planet.INVALID_LOCALE));
        List<Movable> marsProbes = mars.getMovableList();
        assertEquals(1, marsProbes.size());
        Location locationResult = new Location(1,2, Direction.N);
        assertEquals(new Probe(locationResult), marsProbes.get(0));
    }
}
