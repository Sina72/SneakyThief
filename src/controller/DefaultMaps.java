package controller;

import model.Map;
import model.exceptions.OverlapException;
import model.geometry.Coordinate;

public class DefaultMaps {
	private static MapBuilder mapBuilder;
	
	//TODO: make some default maps
	
	public static Map standardMap(){
		mapBuilder = new MapBuilder(200,200);
		
		try {
			//mapBuilder.addWall(Coordinate leftBottom, Coordinate rightTop)
			mapBuilder.addWall(new Coordinate(10,10),new Coordinate(10,190));
			mapBuilder.addWall(new Coordinate(10,190), new Coordinate(130,190));
			mapBuilder.addWall(new Coordinate(70,170), new Coordinate(180,170));
			mapBuilder.addWall(new Coordinate(180,70), new Coordinate(180,170));
			mapBuilder.addWall(new Coordinate(170,30), new Coordinate(170,130));
			mapBuilder.addWall(new Coordinate(70,30), new Coordinate(170,30));
			mapBuilder.addWall(new Coordinate(30,40), new Coordinate(130,40));
			mapBuilder.addWall(new Coordinate(30,40), new Coordinate(30,80));
			
			mapBuilder.addWall(new Coordinate(75,85), new Coordinate(75,115));
			mapBuilder.addWall(new Coordinate(85,75), new Coordinate(115,75));
			mapBuilder.addWall(new Coordinate(85,125), new Coordinate(115,125));
			mapBuilder.addWall(new Coordinate(125,85), new Coordinate(125,115));
			
			mapBuilder.addGuard(new Coordinate(100,100));
			
			//etcetera
			
			
			
			
			
			
		} catch (OverlapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapBuilder.getMap();
	}
	
	public static Map easyMap(){
		mapBuilder = new MapBuilder(200,200);
		
		try {
			//mapBuilder.addWall(Coordinate leftBottom, Coordinate rightTop)
			mapBuilder.addWall(new Coordinate(10,10),new Coordinate(10,190));
			mapBuilder.addWall(new Coordinate(30,30),new Coordinate(30,190));
			mapBuilder.addWall(new Coordinate(50,50),new Coordinate(50,190));
			mapBuilder.addGuard(new Coordinate(100,100));
			
			//etcetera
			
			
			
			
			
			
		} catch (OverlapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapBuilder.getMap();
	}
	
	public static Map sparseMap(){
		mapBuilder = new MapBuilder(300,205);
		//build the map
		
		return mapBuilder.getMap();
	}
	
}
