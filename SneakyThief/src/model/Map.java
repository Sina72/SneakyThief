package model;

import java.util.HashMap;
import java.util.Observable;

/**
 * Represents the map through which the agents move.
 * @author Stan
 *
 */
public class Map extends Observable{
	//Stores all elements and their coordinates. Coordinates are the left bottom corner of the element.
	private HashMap<MapCoordinate, MapElement> elements;
	
	//Dimensions of the map
	private double mapWidth, mapHeight;
	
	/**
	 * Checks whether two elements, each at a coordinate on the map, intersect
	 * @param e1 element one
	 * @param c1 coordinate of element one
	 * @param e2 element two
	 * @param c2 coordinate of element two
	 * @return true if they intersect, false otherwise
	 */
	private static boolean intersects(MapElement e1, MapCoordinate c1, MapElement e2, MapCoordinate c2){
		return false;
	}
}
