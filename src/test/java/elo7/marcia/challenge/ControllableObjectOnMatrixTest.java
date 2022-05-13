package elo7.marcia.challenge;

import elo7.marcia.challenge.model.orientation.ControllableObjectOnMatrix;
import elo7.marcia.challenge.model.orientation.WindRose;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllableObjectOnMatrixTest {

    @Test
    void testLastIndex() {
        ControllableObjectOnMatrix controllableObjectOnMatrix = new ControllableObjectOnMatrix(WindRose.NORTH);
        assertEquals(controllableObjectOnMatrix.getLastIndex(), 3);
    }

    @Test
    void testIndex() {
        ControllableObjectOnMatrix controllableObjectOnMatrix = new ControllableObjectOnMatrix(WindRose.NORTH);
        assertEquals(controllableObjectOnMatrix.getCurrentIndex(), 0);
    }

    @Test
    void testTurnLeft() {
        ControllableObjectOnMatrix controllableObjectOnMatrix = new ControllableObjectOnMatrix(WindRose.NORTH);
        controllableObjectOnMatrix.turnLeft();
        assertEquals(controllableObjectOnMatrix.getCurrentIndex(), 3);
    }

    @Test
    void testTurnRight() {
        ControllableObjectOnMatrix controllableObjectOnMatrix = new ControllableObjectOnMatrix(WindRose.WEST);
        controllableObjectOnMatrix.turnRight();
        assertEquals(controllableObjectOnMatrix.getCurrentIndex(), 0);
    }


}
