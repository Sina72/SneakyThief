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
	public void testAddObstruction() throws OutOfBoundsException,
			OverlapException {
		Obstruction obstruction = 
				new Obstruction(
						new Rectangular(10, 10),  //shape
						0.0 //orientation
						);
		map.addMapElement(
				obstruction, 
				new MapCoordinate(
						0.0, //x
						0.0  //y
						)
				);
		
		// check whether two references refer to the same object through the == operation
		//assertSame( 
		//		map.getObstruction(obstruction) //should return the original obstruction
		//		,obstruction	//the original obstruction
		//		);
	}

	@Test(expected=OutOfBoundsException.class)
	public void testAddObstructionOutOfBoundError() throws OutOfBoundsException, OverlapException {
		Obstruction obstruction = 
				new Obstruction(
						new Rectangular(
								10, //width
								10	//height
								), 
						0.0 //orientation
						);
		map.addMapElement(
				obstruction, 
				new MapCoordinate(
						101.0, 	//x
						0.0		//y
						)
				);
//		assertNotNull(
//				map.getObstruction(obstruction)
//				);
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
