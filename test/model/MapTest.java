package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	private Map map;

	/**
	 * Will be called before every test
	 */
	@Before
	public void setUp() {
		map = new Map(
				100,	//width
				100		//height
				);
	}

	/**
	 * Tests the addObstruction method
	 * 
	 * @throws OutOfBoundsException
	 * @throws OverlapException
	 */
	@Test
	public void testAddObstruction() {

	}

	@Test(expected=OutOfBoundsException.class)
	public void testAddObstructionOutOfBoundError(){
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
