package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import model.exceptions.OutOfBoundsException;
import model.exceptions.OverlapException;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Rectangular;
import model.mapElements.MapPlacement;
import model.mapElements.Obstruction;
import model.mapElements.agents.Agent;
import model.mapElements.agents.Guard;
import model.mapElements.agents.Intruder;

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
		assertSame(map.getAgentsInView(guard).get(0), intruder);
		
	}
	
	//can be tested once intersect works with orientation
	@Ignore @Test
	public void testMoveWithObstruction(){
		
		Map map = new Map(
				200,	//width
				200		//height
				);
		
		Guard a = new Guard(
				new Coordinate(10,10)
				);
		map.addPlacement(a);
		
		Obstruction obstruction = new Obstruction(
				new Line(new Coordinate (0,0),new Coordinate (40,0)),new Coordinate (0,30),0, 0);
		map.addPlacement(obstruction);
		
		
		assertSame(map.move(a,new Coordinate (0,60)),obstruction);
		
	}

	
	@Test
	public void testIntersect(){
		
		Map map = new Map(
				200,	//width
				200		//height
				);
		
		
		Obstruction obstruction = new Obstruction(
				new Line(new Coordinate (0,0),new Coordinate (40,0)),new Coordinate (0,30),0, 0);
		map.addPlacement(obstruction);
		
		Obstruction obstructionTwo = new Obstruction(
				new Line(new Coordinate (0,0),new Coordinate (40,0)),new Coordinate (10,10),Math.PI/2 , 0);
		map.addPlacement(obstructionTwo);
		
		//TODO: fix the orientation for intersect methods.
		assertTrue(obstructionTwo.intersects(obstruction));

		
	}
	
	@Test
	public void testMoveWithoutObstruction(){
		
		Map map = new Map(
				200,	//width
				200		//height
				);
		// set a guard at (10,10)
		Guard a = new Guard(
				new Coordinate(10,10)
				);
		map.addPlacement(a);
		// move the guard to (20,60)
		map.unobstructedMove(a, new Coordinate(10,50));
		assertEquals(a.getCoordinate(),new Coordinate(20,60));
	}
	
	//TODO: fix the inView method
	@Test
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
				new Coordinate(15,10)
				);
		
		map.addPlacement(guard);
		map.addPlacement(intruder);
		
		/*
		//obstruction is a vertical line between the guard and the intruder
		Obstruction obstruction = new Obstruction(
				new Line(new Coordinate (0,0), new Coordinate (0,20) ),
				new Coordinate (30,0),
				0, 0
				);
		map.addPlacement(obstruction);
		*/
		
		//intruder should be seen by the guard
		assertFalse(map.getAgentsInView(guard).isEmpty());
		
	}

}
