package model;

import java.util.HashMap;
import java.util.Observable;

/**
 * Represents the map through which the agents move.
 * @author Stan
 *
 */
public class Map extends Observable {
	//Stores all elements and their coordinates. Coordinates are the left bottom corner of the element.
	//Since Obstructions and Agents are keys, every obstruction or agent can only occur once on the map.
	private HashMap<Obstruction, MapCoordinate> obstructions;
	private HashMap<Agent, MapCoordinate> agents;

	//Dimensions of the map
	private double mapWidth, mapHeight;
	
	public Map(double width, double height){
		mapWidth = width;
		mapHeight = height;
		obstructions = new HashMap<Obstruction, MapCoordinate>();
		agents = new HashMap<Agent, MapCoordinate>();
	}
	
	/**
	 * Adds an Obstruction to t map
	 * @param obstruction The Obstruction to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the obstruction.
	 */
	private void addObstruction(Obstruction obstruction, MapCoordinate coordinate){
		obstructions.put(obstruction, coordinate);
	}
	
	/**
	 * Checks whether there is overlap between the specified and any existing MapElement
	 * @param element The element to be checked
	 * @param coordinate At this coordinate
	 * @return
	 */
	private boolean checkOverlap(MapElement element,
			MapCoordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks whether the MapElement would go out of bound at the specified MapCoordinate
	 * @param element MapElement that should be checked
	 * @param coordinate The MapCoordinate at which the MapElement should be checked
	 * @return
	 */
	private boolean checkOutOfBounds(MapElement element,
			MapCoordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	public Obstruction getObstruction(Obstruction obstruction) {
		//TODO: implementation
		return null;
	}
	
	/**
	 * Adds an Agent to the map
	 * @param obstruction The Agent to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the Agent.
	 * @throws OutOfBoundsException if the Agent does not fit into the map at the speficied coordinates
	 */
	private void addAgent(Agent element, MapCoordinate coordinate) throws OutOfBoundsException, OverlapException {
		// TODO Implementation including out of bounds check
	}
	
	/**
	 * 
	 * @param element The MapElement to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the MapElement
	 * @throws OutOfBoundsException if the MapElement does not fit into the map at the specified coordinates.
	 */
	public void addMapElement(MapElement element, MapCoordinate coordinate) throws OutOfBoundsException, OverlapException{
		
		//check whether the placement is valid
		if(checkOutOfBounds(element,coordinate))
			throw new OutOfBoundsException();
		if(checkOverlap(element,coordinate))
			throw new OverlapException();
		
		//call the right function based on MapElement type
		if(element instanceof Obstruction)
			addObstruction((Obstruction) element, coordinate);
		else if(element instanceof Agent)
			addAgent((Agent) element, coordinate);
		else{
			System.err.println("Invalid MapElement");
		}
	}
	
	/**
	 * Remove Obstruction from the Map
	 * @param obstruction Obstruction to be removed.
	 */
	private void removeObstruction(Obstruction obstruction){
		obstructions.remove(obstruction);
	}
	
	/**
	 * Remove Agent from the Map
	 * @param agent Agent to be removed
	 */
	private void removeAgent(Agent agent){
		agents.remove(agent);
	}
	
	/**
	 * Remove MapElement from the Map
	 * @param element MapElement to be removed.
	 */
	public void removeMapElement(MapElement element){
		if(element instanceof Obstruction)
			removeObstruction((Obstruction) element);
		if(element instanceof Agent)
			removeAgent((Agent) element);
		else{
			System.err.println("Invalid MapElement");
		}
	}



	/**
	 * Checks whether two elements, each at a coordinate on the map, intersect
	 * @param e1 element one
	 * @param c1 coordinate of element one
	 * @param e2 element two
	 * @param c2 coordinate of element two
	 * @return true if they intersect, false otherwise
	 */
	public static boolean intersects(MapElement e1, MapCoordinate c1,
			MapElement e2, MapCoordinate c2) {
		
		//TODO:Implement method
		
		return false;
	}
}
