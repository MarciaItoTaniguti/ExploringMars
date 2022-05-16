package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExploreApplicationTest {

	@Test
	void deployProbeFirst() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "MRMMLM";
		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(1,2,Direction.N), probe, mars);
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(3,4, Direction.N)));
	}

	@Test
	void deployProbeSecond() throws Exception {
        Planet mars = new Planet(5,5);

		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(3,3,Direction.E), probe, mars);
		String instructions = "MMRMMRMRRM";
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(5,1, Direction.E)));
	}

	@Test
	void deploySecondProbeCollide() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "LMMLMLM";
		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(2,1,Direction.E), probe, mars);
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(1,2, Direction.S)));

		Probe probe2 = new Probe();

		Exception exception = assertThrows(
				Exception.class,
				() -> DeployOnPlanet.execute(new Location(1,2,Direction.N), probe2, mars));

		assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
	}

	@Test
	void deployProbeCollisionOnMove() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "LMMLMLM";
		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(2,1,Direction.E), probe, mars);
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(1,2, Direction.S)));

		Probe probe2 = new Probe();
		DeployOnPlanet.execute(new Location(0,3,Direction.E), probe2, mars);
		String instructions2 = "MRMMLM";
		probe2.runInstructions(instructions2, mars);

		assertNotNull(mars.getObjects().get(new Location(1,3, Direction.S)));
	}

	@Test
	void deployProbeOutOfBordLimit() throws Exception {
		Planet mars = new Planet(5,5);
		Probe probe = new Probe();
		Exception exception = assertThrows(
				Exception.class,
				() -> DeployOnPlanet.execute(new Location(6,6,Direction.N), probe, mars));

		assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
	}

	@Test
	void deployProbeOutOfBordLimitSec() throws Exception {
		Planet mars = new Planet(5,5);
		Probe probe = new Probe();
		Exception exception = assertThrows(
				Exception.class,
				() -> DeployOnPlanet.execute(new Location(-3,2,Direction.N), probe, mars));

		assertTrue(exception.getMessage().contains(DeployOnPlanet.INVALID_LOCALE));
	}

	@Test
	void MoveProbeOutOfBordLimit() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "LLMRMMRRL";
		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(4,0,Direction.S), probe, mars);
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(5,1, Direction.E)));
	}

	@Test
	void MoveProbeOutOfBordLimitSec() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "MRRMMLM";
		Probe probe = new Probe();
		DeployOnPlanet.execute(new Location(0,3,Direction.E), probe, mars);
		probe.runInstructions(instructions, mars);

		assertNotNull(mars.getObjects().get(new Location(0,3, Direction.W)));
	}

}
