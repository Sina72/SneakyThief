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
			mapBuilder.addWall(
					new Coordinate(0,0), 
					new Coordinate(200,5)
					);
			
			mapBuilder.addGuard(new Coordinate(30,30));
			
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
