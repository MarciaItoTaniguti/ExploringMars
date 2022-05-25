package elo7.marcia.challenge;

import elo7.marcia.challenge.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExploreApplicationTest {

	@Test
	void deployProbeFirst() throws Exception {

		Planet mars = new Planet(5,5);

		String instructions = "MRMMLM";
		Probe probe = new Probe(new Location(1,2,Direction.N));
		probe.deploy(mars);
		probe.runInstructions(instructions, mars);

		Location locationResult = new Location(3,4, Direction.N);
		List<Movable> marsProbes = mars.getMovableList();
		assertEquals(new Probe(locationResult),marsProbes.get(0));
	}

	@Test
	void deployProbeSecond() throws Exception {
		Planet mars = new Planet(5,5);

		Probe probe = new Probe(new Location(3,3,Direction.E));
		probe.deploy(mars);
		String instructions = "MMRMMRMRRM";
		probe.runInstructions(instructions, mars);

		Location locationResult = new Location(5,1, Direction.E);
		List<Movable> marsProbes = mars.getMovableList();
		assertEquals(new Probe(locationResult), marsProbes.get(0));
	}

	@Test
	void deploySecondProbeCollide() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "LMMLMLM";
		Location locationProbe1 = new Location(2,1,Direction.E);
		Probe probe = new Probe(locationProbe1);
		probe.runInstructions(instructions, mars);

		Location locationProbe2 = new Location(1,2,Direction.N);
		Probe probe2 = new Probe(locationProbe2);

		Exception exception = assertThrows(
				Exception.class,
				() -> probe2.deploy(mars));

		assertTrue(exception.getMessage().contains(Planet.INVALID_LOCALE));
		Location locationResult = new Location(1,2, Direction.S);
		List<Movable> marsProbes = mars.getMovableList();
		assertEquals(1, marsProbes.size());
		assertEquals(new Probe(locationResult), marsProbes.get(0));
	}

	@Test
	void deployProbeCollisionOnMove() throws Exception {
		Planet mars = new Planet(5,5);

		Probe probe = new Probe(new Location(2,1,Direction.E));
		probe.deploy(mars);
		String instructions = "LMMLMLM";
		probe.runInstructions(instructions, mars);

		Probe probe2 = new Probe(new Location(0,3,Direction.E));
		probe2.deploy(mars);
		String instructions2 = "MRMMLM";
		probe2.runInstructions(instructions2, mars);

		Location locationResult1 = new Location(1,2, Direction.S);
		Location locationResult2 = new Location(1,3, Direction.S);
		List<Movable> marsProbes = mars.getMovableList();
		assertEquals(new Probe(locationResult1), marsProbes.get(0));
		assertEquals(new Probe(locationResult2), marsProbes.get(1));
	}

	@Test
	void deployProbeOutOfBordLimit() throws Exception {
		Planet mars = new Planet(5,5);
		Probe probe = new Probe(new Location(6,6,Direction.N));
		Exception exception = assertThrows(
				Exception.class,
				() -> probe.deploy(mars));

		assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
	}

	@Test
	void deployProbeOutOfBordLimitSec() throws Exception {
		Planet mars = new Planet(5,5);
		Probe probe = new Probe(new Location(-3,2,Direction.N));
		Exception exception = assertThrows(
				Exception.class,
				() -> probe.deploy(mars));

		assertTrue(exception.getMessage().contains(Planet.OUT_OF_BORD));
	}

	@Test
	void MoveProbeOutOfBordLimit() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "LLMRMMRRL";
		Probe probe = new Probe(new Location(4,0,Direction.S));
		probe.deploy(mars);
		probe.runInstructions(instructions, mars);

		List<Movable> marsProbes = mars.getMovableList();
		Location locationResult = new Location(5,1, Direction.E);
		assertEquals(new Probe(locationResult), marsProbes.get(0));
	}

	@Test
	void MoveProbeOutOfBordLimitSec() throws Exception {
		Planet mars = new Planet(5,5);

		String instructions = "MRRMMLM";
		Probe probe = new Probe(new Location(0,3,Direction.E));
		probe.deploy(mars);
		probe.runInstructions(instructions, mars);

		List<Movable> marsProbes = mars.getMovableList();
		Location locationResult = new Location(0,3, Direction.W);
		assertEquals(new Probe(locationResult), marsProbes.get(0));
	}

}
