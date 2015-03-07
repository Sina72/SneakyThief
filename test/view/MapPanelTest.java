package view;

import model.Map;
import model.geometry.Coordinate;
import model.geometry.Polygonal;
import model.geometry.Rectangular;
import model.mapElements.Obstruction;
import model.mapElements.agents.Guard;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapPanelTest {
	
	private static Map map;

	
	public static void main(String[] args){
		try {
			setUpBeforeClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MapPanelTest mapPanelTest = new MapPanelTest();
		mapPanelTest.test();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		map = new Map(100, 100);
		
		map.addPlacement(new Guard(new Coordinate(50,50)));
		map.addPlacement(new Obstruction(
				new Polygonal(
						new Coordinate(0,0), 
						new Coordinate(10,0), 
						new Coordinate(15,10),
						new Coordinate(10,20),
						new Coordinate(0,20),
						new Coordinate(-5,10)
						), //Shape
					new Coordinate(30,20), // Location
					Math.PI/2 //Orientation
					)
				);
		map.addPlacement(new Obstruction(
					new Rectangular(80,2),
					new Coordinate(0,0),
					0
				));
		map.addPlacement(new Obstruction(
				new Rectangular(80,2),
				new Coordinate(2.1,80.1),
				0
			));
		map.addPlacement(new Obstruction(
				new Rectangular(2,80),
				new Coordinate(0,2.1),
				0
			));
		map.addPlacement(new Obstruction(
				new Rectangular(2,60),
				new Coordinate(80.1,0),
				0
			));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		new MainFrame().add(new MapPanel(map));
	}

}
