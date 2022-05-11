package elo7.marcia.challenge;

import elo7.marcia.challenge.model.CoordinatePoint;
import elo7.marcia.challenge.model.CoordinatePointOnMatrix;
import elo7.marcia.challenge.model.WindRose;
import elo7.marcia.challenge.model.MarsPlain;
import elo7.marcia.challenge.model.Probe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ExploreApplicationTests {
	@Test
	void deployProbeFirst() {
		CoordinatePoint highestCoordinatePoint = new CoordinatePointOnMatrix(5,5);
		MarsPlain mars = new MarsPlain(highestCoordinatePoint);
		Probe probe = ProbeBuilder.generateProbeOne();
		probe.runInstructions(ProbeBuilder.getInstructionForProbeOne(), mars);

		assertEquals(new CoordinatePointOnMatrix(5, 1), probe.getLocation());
		assertEquals(WindRose.EAST, probe.getPointsTo());
	}

	@Test
	void deployProbeSecond() {
		CoordinatePoint highestCoordinatePoint = new CoordinatePointOnMatrix(5,5);
		MarsPlain mars = new MarsPlain(highestCoordinatePoint);
		Probe probe = ProbeBuilder.generateProbeTwo();
		probe.runInstructions(ProbeBuilder.getInstructionForProbeTwo(), mars);

		assertEquals(new CoordinatePointOnMatrix(1,3), probe.getLocation());
		assertEquals(WindRose.NORTH, probe.getPointsTo());
	}
}
