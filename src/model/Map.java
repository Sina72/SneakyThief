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
	 * @throws OutOfBoundsException if the obstruction does not fit into the map at the specified coordinates
	 */
	public void addObstruction(Obstruction obstruction, MapCoordinate coordinate) throws OutOfBoundsException, OverlapException{
		//TODO: Implementation including out of bounds check
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
		if(element instanceof Obstruction)
			addObstruction((Obstruction) element, coordinate);
		else if(element instanceof Agent)
			addAgent((Agent) element, coordinate);
		else{
			//TODO: default implementation
		}
	}
	
	/**
	 * Remove Obstruction from the Map
	 * @param obstruction Obstruction to be removed.
	 */
	public void removeObstruction(Obstruction obstruction){
		//TODO: implement removeObstruction
	}
	
	/**
	 * Remove Agent from the Map
	 * @param agent Agent to be removed
	 */
	public void removeAgent(Agent agent){
		//TODO: implement removeAgent
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
			//TODO: default case
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
