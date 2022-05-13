package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import elo7.marcia.challenge.model.orientation.MovementOptions;
import elo7.marcia.challenge.model.orientation.WindRose;
import elo7.marcia.challenge.model.planet.MarsSurface;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class ExploreApplicationTest {

	@Test
	void deployProbeFirst() throws Exception {
		CoordinatePoint highestCoordinatePoint = new CoordinatePoint(5,5);
		MarsSurface mars = new MarsSurface(highestCoordinatePoint);
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
		Probe probe = new Probe(new CoordinatePoint(3,3), WindRose.EAST, exploreInstructions);
		mars.deployProbe(probe);
		probe.runInstructions(mars);

		assertEquals(new CoordinatePoint(5, 1), probe.getLocation());
		assertEquals(WindRose.EAST, probe.getCurrentDirection());
	}

	@Test
	void deployProbeSecond() throws Exception {
		MarsSurface mars = new MarsSurface(new CoordinatePoint(5,5));

		List<MovementOptions> instruction = Lists.newArrayList(MovementOptions.MOVE, MovementOptions.TURN_RIGHT,MovementOptions.MOVE,MovementOptions.MOVE, MovementOptions.TURN_LEFT, MovementOptions.MOVE);

		Probe probe = new Probe(new CoordinatePoint(1,2), WindRose.NORTH,instruction);
		mars.deployProbe(probe);
		probe.runInstructions(mars);

		assertEquals(new CoordinatePoint(3,4), probe.getLocation());
		assertEquals(WindRose.NORTH, probe.getCurrentDirection());
	}

	@Test
	void deploySecondProbeCollide() throws Exception {
		MarsSurface mars = new MarsSurface(new CoordinatePoint(5,5));

		List<MovementOptions> instructions = Lists.newArrayList(MovementOptions.TURN_LEFT,MovementOptions.MOVE,MovementOptions.MOVE,MovementOptions.TURN_LEFT,MovementOptions.MOVE,MovementOptions.TURN_LEFT,MovementOptions.MOVE);
		Probe probeOne = new Probe(new CoordinatePoint(2,1), WindRose.EAST, instructions);
		mars.deployProbe(probeOne);
		probeOne.runInstructions(mars);

		assertEquals(new CoordinatePoint(1,2), probeOne.getLocation());
		assertEquals(WindRose.SOUTH, probeOne.getCurrentDirection());

		Probe probeTwo = new Probe(new CoordinatePoint(1,2), WindRose.NORTH, null);
		Exception exception = assertThrows(
				Exception.class,
				() -> mars.deployProbe(probeTwo));


		assertTrue(exception.getMessage().contains(MarsSurface.LOCALE_NOT_AVAILABLE));
	}

	@Test
	void deployProbeCollisionOnMove() throws Exception {
		CoordinatePoint highestCoordinatePoint = new CoordinatePoint(5,5);
		MarsSurface mars = new MarsSurface(highestCoordinatePoint);

		List<MovementOptions> instructions = Lists.newArrayList(MovementOptions.TURN_LEFT, MovementOptions.MOVE, MovementOptions.MOVE, MovementOptions.TURN_LEFT, MovementOptions.MOVE, MovementOptions.TURN_LEFT,MovementOptions.MOVE);
		Probe probeOne = new Probe(new CoordinatePoint(2,1), WindRose.EAST, instructions);
		mars.deployProbe(probeOne);
		probeOne.runInstructions(mars);

		assertEquals(new CoordinatePoint(1,2), probeOne.getLocation());
		assertEquals(WindRose.SOUTH, probeOne.getCurrentDirection());

		List<MovementOptions> instProb2 = Lists.newArrayList(MovementOptions.MOVE, MovementOptions.TURN_RIGHT, MovementOptions.MOVE, MovementOptions.MOVE, MovementOptions.TURN_LEFT, MovementOptions.MOVE);
		Probe probeTwo = new Probe(new CoordinatePoint(0,3), WindRose.EAST,instProb2);
		mars.deployProbe(probeTwo);
		probeTwo.runInstructions(mars);
		assertEquals(new CoordinatePoint(1,3), probeTwo.getLocation());
		assertEquals(WindRose.SOUTH, probeTwo.getCurrentDirection());
	}

	@Test
	void deployProbeOutOfBordLimit() {
		CoordinatePoint highestCoordinatePoint = new CoordinatePoint(5,5);
		MarsSurface mars = new MarsSurface(highestCoordinatePoint);

		Probe probe = new Probe(new CoordinatePoint(6,6), WindRose.NORTH, null);

		Exception exception = assertThrows(
				Exception.class,
				() -> mars.deployProbe(probe));

		assertTrue(exception.getMessage().contains(MarsSurface.LOCALE_NOT_AVAILABLE));
	}

	@Test
	void MoveProbeOutOfBordLimit() throws Exception {
		CoordinatePoint highestCoordinatePoint = new CoordinatePoint(5,5);
		MarsSurface mars = new MarsSurface(highestCoordinatePoint);

		List<MovementOptions> instProb = Lists.newArrayList(MovementOptions.MOVE,MovementOptions.TURN_RIGHT,MovementOptions.MOVE,MovementOptions.MOVE,MovementOptions.TURN_RIGHT,MovementOptions.TURN_RIGHT,MovementOptions.TURN_LEFT);
		Probe probe = new Probe(new CoordinatePoint(4,0), WindRose.NORTH,instProb);
		mars.deployProbe(probe);
		probe.runInstructions(mars);
		assertEquals(new CoordinatePoint(5,1), probe.getLocation());
		assertEquals(WindRose.EAST, probe.getCurrentDirection());
	}

	@Test
	void MoveProbeOutOfBordLimitSec() throws Exception {
		CoordinatePoint highestCoordinatePoint = new CoordinatePoint(5,5);
		MarsSurface mars = new MarsSurface(highestCoordinatePoint);

		List<MovementOptions> instProb = Lists.newArrayList(MovementOptions.MOVE,MovementOptions.TURN_RIGHT,MovementOptions.TURN_RIGHT,MovementOptions.MOVE,MovementOptions.MOVE,MovementOptions.TURN_LEFT,MovementOptions.MOVE);
		Probe probe = new Probe(new CoordinatePoint(0,3), WindRose.EAST,instProb);
		mars.deployProbe(probe);
		probe.runInstructions(mars);
		assertEquals(new CoordinatePoint(0,3), probe.getLocation());
		assertEquals(WindRose.WEST, probe.getCurrentDirection());
	}

}
