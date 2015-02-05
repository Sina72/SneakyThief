package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	private Map map;

	/**
	 * Will be called before every test
	 */
	@Before
	public void setUp() {
		map = new Map(100, 100);
	}

	/**
	 * Tests the addObstruction method
	 * 
	 * @throws OutOfBoundsException
	 * @throws OverlapException
	 */
	@Test
	public void testAddObstruction() throws OutOfBoundsException,
			OverlapException {
		Obstruction obstruction = new Obstruction(new Rectangular(10, 10), 0.0);
		map.addObstruction(obstruction, new MapCoordinate(0.0, 0.0));
		assertNotNull(map.getObstruction(obstruction));
	}

	@Test(expected=OutOfBoundsException.class)
	public void testAddObstructionOutOfBoundError() throws OutOfBoundsException, OverlapException {
		Obstruction obstruction = new Obstruction(new Rectangular(10, 10), 0.0);
		map.addObstruction(obstruction, new MapCoordinate(101.0, 0.0));
		assertNotNull(map.getObstruction(obstruction));
	}

	@Test
	public void testAddMapElement() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveObstruction() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAgent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMapElement() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntersects() {
		fail("Not yet implemented");
	}

}
