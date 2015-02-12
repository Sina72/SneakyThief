package model;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import model.exceptions.OutOfBoundsException;
import model.exceptions.OverlapException;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Rectangular;
import model.mapElements.MapPlacement;
import model.mapElements.Agents.Guard;
import model.mapElements.Agents.Intruder;
import model.mapElements.obstructions.Obstruction;

import org.junit.Ignore;
import org.junit.Test;


public class MapTest {


	/**
	 * Tests the addObstruction method
	 * 
	 * @throws OutOfBoundsException
	 * @throws OverlapException
	 */
	@Test
	public void testAddObstruction() {
		Map map = new Map(
				200,	//width
				200		//height
				);
		
		Obstruction obstruction = new Obstruction(
				new Rectangular(10.0,20.0), 
				new Coordinate(0,0), 
				0,
				0);
		
		map.addPlacement(obstruction);
		
		Iterator<MapPlacement> it = map.iterator();

		assertSame(it.next(), obstruction);
	}
	
	//can be tested as soon as the agent constants work
	@Ignore @Test
	public void testGetInView() {
		Map map = new Map(
				200,	//width
				200		//height
				);
		
		Guard guard = new Guard(
				new Coordinate(10,10)
				);
		Intruder intruder = new Intruder(
				new Coordinate(20,10)
				);
		
		map.addPlacement(guard);
		map.addPlacement(intruder);
		
		//intruder should be seen by the agent
		assertSame(map.getInView(guard).get(0), intruder);
		
	}
	
	//can be tested as soon as the agent constants work
	@Ignore @Test
	public void testGetInViewWithObstruction(){
		
		Map map = new Map(
				200,	//width
				200		//height
				);
		
		//set a guard and an intruder 10 m apart
		Guard guard = new Guard(
				new Coordinate(10,10)
				);
		Intruder intruder = new Intruder(
				new Coordinate(20,10)
				);
		
		map.addPlacement(guard);
		map.addPlacement(intruder);
		
		//obstruction is a vertical line between the guard and the intruder
		Obstruction obstruction = new Obstruction(
				new Line( new Coordinate (5,10) ),
				new Coordinate (15,0),
				0, 0
				);
		map.addPlacement(obstruction);
		
		//intruder should not be seen by the guard
		assertTrue(map.getInView(guard).isEmpty());
		
	}

}
