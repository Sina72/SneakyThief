/**
 * 
 */
package model.mapElements;

import static org.junit.Assert.*;
import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Polygonal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Stan
 *
 */
public class MapPlacementTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntersectLineLineTrue() {
		Line one = new Line(new Coordinate(0,0), new Coordinate(10,10));
		Line two = new Line(new Coordinate(10,0), new Coordinate(0,10));
		MapPlacement placement = new MapPlacement(one,new Coordinate(0,0),0.0);
		MapPlacement otherPlacement = new MapPlacement(two,new Coordinate(0,0),0);
		assertTrue(placement.intersects(otherPlacement) != null);
	}
	
	@Test
	public void testIntersectLineLineFalse(){
		Line one = new Line(new Coordinate(0,0), new Coordinate(0,10));
		Line two = new Line(new Coordinate(10,0), new Coordinate(10,10));
		MapPlacement placement = new MapPlacement(one,new Coordinate(0,0),0.0);
		MapPlacement otherPlacement = new MapPlacement(two,new Coordinate(0,0),0);
		assertFalse(placement.intersects(otherPlacement) != null);
	}
	
	@Test
	public void testIntersectCircCircTrue(){
		Circular one = new Circular(10);
		Circular two = new Circular(10);
		
		MapPlacement placement = new MapPlacement(
				one, //shape
				new Coordinate(10,10), //coordinate
				0 //orientation
				);
		MapPlacement otherPlacement = new MapPlacement(
				two, //shape 
				new Coordinate(10,29), //coordinate
				0 //orientation
				);
		
		assertTrue(placement.intersects(otherPlacement) != null);
	}
	
	@Test
	public void testIntersectCircCircFalse(){
		Circular one = new Circular(10);
		Circular two = new Circular(10);
		
		MapPlacement placement = new MapPlacement(
				one, //shape
				new Coordinate(10,10), //coordinate
				0 //orientation
				);
		MapPlacement otherPlacement = new MapPlacement(
				two, //shape 
				new Coordinate(10,31), //coordinate
				0 //orientation
				);
		
		assertFalse(placement.intersects(otherPlacement) != null);
	}
	
	@Test
	public void testIntersectPolyPolyTrue(){
		Polygonal one = new Polygonal(
				new Coordinate (0,0),
				new Coordinate (10,0),
				new Coordinate (10,10),
				new Coordinate (0,10)
				);
		
		Polygonal two = new Polygonal(
				new Coordinate (0,0),
				new Coordinate (10,0),
				new Coordinate (15,10),
				new Coordinate (10,20),
				new Coordinate (0,20),
				new Coordinate (-5,10)
				);
		
		MapPlacement placementOne = new MapPlacement(
				one,
				new Coordinate(0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				two,
				new Coordinate (10,10),
				30
				);
		
		assertTrue(placementOne.intersects(placementTwo) != null);
	}
	
	@Test
	public void testIntersectPolyPolyFalse(){
		Polygonal one = new Polygonal(
				new Coordinate (0,0),
				new Coordinate (10,0),
				new Coordinate (10,10),
				new Coordinate (0,10)
				);
		
		Polygonal two = new Polygonal(
				new Coordinate (0,0),
				new Coordinate (10,0),
				new Coordinate (15,10),
				new Coordinate (10,20),
				new Coordinate (0,20),
				new Coordinate (-5,10)
				);
		
		MapPlacement placementOne = new MapPlacement(
				one,
				new Coordinate(0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				two,
				new Coordinate (100,10),
				0
				);
		
		assertFalse(placementOne.intersects(placementTwo) != null);
	}
	
	@Test
	public void testIntersectCircLineTrue(){
		Circular circ = new Circular(10);
		
		Line line = new Line(
				new Coordinate(-10,-10),
				new Coordinate(10,10)
				);
		
		MapPlacement placementOne = new MapPlacement(
				circ,
				new Coordinate (0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				line,
				new Coordinate(0,0),
				0
				);
		
		assertTrue(placementOne.intersects(placementTwo) != null);
	}
	
	@Test
	public void testIntersectCircLineFalse(){
		Circular circ = new Circular(10);
		
		Line line = new Line(
				new Coordinate(20,0),
				new Coordinate(0,19));
		
		MapPlacement placementOne = new MapPlacement(
				circ,
				new Coordinate (0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				line,
				new Coordinate(0,0),
				0
				);
		
		assertFalse(placementOne.intersects(placementTwo) != null);
	}
	
	@Test
	public void testIntersectCircPolyTrue(){
		Circular circ = new Circular(10);
		
		Polygonal poly = new Polygonal(
				new Coordinate (20,0),
				new Coordinate (0,19),
				new Coordinate (15,7),
				new Coordinate (0,0)
				);
		
		MapPlacement placementOne = new MapPlacement(
				circ,
				new Coordinate (0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				poly,
				new Coordinate(2,0),
				0
				);
		
		assertTrue(placementOne.intersects(placementTwo) != null);
	}
	
	@Test
	public void testIntersectCircPolyFalse(){
		Circular circ = new Circular(10);
		
		Polygonal poly = new Polygonal(
				new Coordinate (20,0),
				new Coordinate (0,19),
				new Coordinate (15,7),
				new Coordinate (0,0)
				);
		
		MapPlacement placementOne = new MapPlacement(
				circ,
				new Coordinate (0,0),
				0
				);
		
		MapPlacement placementTwo = new MapPlacement(
				poly,
				new Coordinate(100,0),
				0
				);
		
		assertFalse(placementOne.intersects(placementTwo) != null);
	}

}
