package controller;

import java.util.Random;

import model.Map;
import model.exceptions.OverlapException;
import model.geometry.Coordinate;
import model.mapElements.agents.Guard;

public class DefaultMaps {
	private static MapBuilder mapBuilder;
	
	//TODO: make some default maps
	
	public static Map standardMap(){
		mapBuilder = new MapBuilder(200,200);
		
		try {
			//mapBuilder.addWall(Coordinate leftBottom, Coordinate rightTop)
			mapBuilder.addWall(new Coordinate(45,55), new Coordinate(45,145));
			mapBuilder.addWall(new Coordinate(55,45), new Coordinate(145,45));
			mapBuilder.addWall(new Coordinate(55,155), new Coordinate(145,155));
			mapBuilder.addWall(new Coordinate(155,55), new Coordinate(155,145));
			mapBuilder.addDoor(new Coordinate(45,90), new Coordinate(45,110));
			
		} catch (OverlapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapBuilder.getMap();
	}
	
	public static Map mazeMap(){
		mapBuilder = new MapBuilder(200,200);
		
		try {
			//mapBuilder.addWall(Coordinate leftBottom, Coordinate rightTop)
			mapBuilder.addWall(new Coordinate(10,10),new Coordinate(10,190));
			mapBuilder.addWall(new Coordinate(10.1,190), new Coordinate(130,190));
			mapBuilder.addWall(new Coordinate(70,170), new Coordinate(180,170));
			mapBuilder.addWall(new Coordinate(180,70), new Coordinate(180,169.9));
			mapBuilder.addWall(new Coordinate(170,30.1), new Coordinate(170,120));
			mapBuilder.addWall(new Coordinate(70,30), new Coordinate(170,30));
			mapBuilder.addWall(new Coordinate(30,40), new Coordinate(50,40));
			mapBuilder.addWall(new Coordinate(30,40.1), new Coordinate(30,80));
			
			mapBuilder.addWall(new Coordinate(75,85), new Coordinate(75,115));
			mapBuilder.addWall(new Coordinate(85,75), new Coordinate(115,75));
			mapBuilder.addWall(new Coordinate(85,125), new Coordinate(115,125));
			mapBuilder.addWall(new Coordinate(125,85), new Coordinate(125,115));
			
			//Guard guard = new Guard(new Coordinate(100,100));
			//guard.LoadSettingsXML("./settings/settings.xml");
			//mapBuilder.addPlacement(guard);
			//Guard guard2 = new Guard(new Coordinate(100,100));
			//guard2.LoadSettingsXML("./settings/settings.xml");
			//mapBuilder.addPlacement(guard2);
			//mapBuilder.addGuard(new Coordinate(100,100));
			//mapBuilder.addGuard(new Coordinate(50,50));
			//mapBuilder.addGuard(new Coordinate(150,150));
			mapBuilder.addGuards(10);
		
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
			mapBuilder.addWall(new Coordinate(45,55), new Coordinate(45,145));
			mapBuilder.addWall(new Coordinate(55,45), new Coordinate(145,45));
			mapBuilder.addWall(new Coordinate(55,155), new Coordinate(145,155));
			mapBuilder.addWall(new Coordinate(155,55), new Coordinate(155,145));
			
		} catch (OverlapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapBuilder.getMap();
	}
	
	public static Map doubleWallMap(){
		mapBuilder = new MapBuilder(200,200);
		
		try {
			//mapBuilder.addWall(Coordinate leftBottom, Coordinate rightTop)
			mapBuilder.addWall(new Coordinate(86,86), new Coordinate(114,87));
			mapBuilder.addWall(new Coordinate(86,87.1), new Coordinate(87,115));
			mapBuilder.addWall(new Coordinate(87.1,114), new Coordinate(115,115));
			mapBuilder.addWall(new Coordinate(114.1,86), new Coordinate(115,113.9));
//			mapBuilder.addWall(new Coordinate(50,50), new Coordinate(100,100));
//			mapBuilder.addWall(new Coordinate(150,50), new Coordinate(200,100));
			
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
	
	public static Map customMap(int width, int height)
	{
		mapBuilder = new MapBuilder(width,height);
		
		//editor paconnections
		
		return mapBuilder.getMap();
		
	}
	
}
