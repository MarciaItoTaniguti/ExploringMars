package elo7.marcia.challenge;

import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinatePointTest {

    @Test
    void testEquals() {
        CoordinatePoint pointFist = new CoordinatePoint(1,3);
        CoordinatePoint pointSec = new CoordinatePoint(1,3);

        assertEquals(pointFist, pointSec);
    }

    @Test
    void testNotEquals() {
        CoordinatePoint pointFist = new CoordinatePoint(1,3);
        CoordinatePoint pointSec = new CoordinatePoint(1,8);

        assertNotEquals(pointFist, pointSec);
    }

}
