package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * Represents the map through which the agents move.
 * @author Stan
 *
 */
public class Map extends Observable implements Iterable<MapPlacement<? extends MapElement>> {
	//Stores all elements and their coordinates. Coordinates are the left bottom corner of the element.
	//Since Obstructions and Agents are keys, every obstruction or agent can only occur once on the map.
	
	private List<MapPlacement<? extends MapElement>> placements;

	private List<MapPlacement<Obstruction>> obstructions;
	private List<MapPlacement<Agent>> agents;

	//Dimensions of the map
	private double mapWidth, mapHeight;
	
	public Map(double width, double height){
		mapWidth = width;
		mapHeight = height;
		placements = new ArrayList<MapPlacement<? extends MapElement>>();
	}
	
	/**
	 * Returns all agents in view
	 * @param agent agent of which the view should be determined
	 * @return List<Agent> of all agents in view of Agent agent
	 */
	public List<Agent> getInView(MapPlacement<Agent> agentPlacement){
		ArrayList<Agent> agentsInView = new ArrayList<Agent>();
		
		Iterator<MapPlacement<Agent>> it = agents.iterator();
		while(it.hasNext()){
			MapPlacement<Agent> otherAgentPlacement = it.next();
			if(inView(agentPlacement, otherAgentPlacement))
				agentsInView.add(otherAgentPlacement.getMapElement());
		}

		return agentsInView;
	}
	
	/**
	 * Checks whether a coordinate is in view of an agent
	 * @param agent agent of which the view should be determined
	 * @param coordinate coordinate to check whether it is in view of the agent
	 * @return true if coordinate in view, false otherwise
	 */
	//TODO: does not check any obstructions
	private boolean inView(MapPlacement<Agent> agentPlacement, MapPlacement<Agent> otherAgentPlacement){
		Agent agent = agentPlacement.getMapElement();
		double orientation = agent.getOrientation();
		double visionAngle = agent.getVisionAngle();
		double maxVision = agent.getMaxVisionRange();
		double minVision = agent.getMinVisionRange();
		
		MapCoordinate agentPosition = agentPlacement.getMapCoordinate();
		MapCoordinate otherAgentPosition = otherAgentPlacement.getMapCoordinate();
		
		double distanceBetweenAgents = MapCoordinate.getDistance(agentPosition, otherAgentPosition);
		
		if(
				distanceBetweenAgents > maxVision || 
				distanceBetweenAgents < minVision)
			return false;
		
		//gets the angle from the agent to the coordinate
		double angleBetweenAgents = MapCoordinate.getAngle(agentPosition,otherAgentPosition);
		
		//checks totalvisionangel /2 on either side of the orientation
		if( angleBetweenAgents > orientation + visionAngle / 2 || angleBetweenAgents < orientation - visionAngle / 2)
			return false;
		
		return true;
	}
	
	
	/**
	 * Adds an Obstruction to t map
	 * @param obstruction The Obstruction to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the obstruction.
	 */
	private void addObstruction(Obstruction obstruction, MapCoordinate coordinate){
		MapPlacement<Obstruction> newPlacement = new MapPlacement<Obstruction>(obstruction, coordinate);
		obstructions.add(newPlacement);
		placements.add(newPlacement);
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
		return 
				coordinate.getX() + element.getWidth() > mapWidth || // width is exceeded
				coordinate.getY() + element.getHeight() > mapHeight; // height is exceeded
	}
	
	/**
	 * Adds an Agent to the map
	 * @param obstruction The Agent to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the Agent.
	 * @throws OutOfBoundsException if the Agent does not fit into the map at the speficied coordinates
	 */
	private void addAgent(Agent element, MapCoordinate coordinate){
		MapPlacement<Agent> newPlacement = new MapPlacement<Agent>(element, coordinate);
		agents.add(newPlacement);
		placements.add(newPlacement);
	}
	
	public void rinseAgents(){
		for(MapPlacement<Agent> agent : agents )
			placements.remove(agent);
			
	}
	
	/**
	 * 
	 * @param element The MapElement to be added to the map
	 * @param coordinate the MapCoordinate of the left bottom corner of the MapElement
	 * @throws OutOfBoundsException if the MapElement does not fit into the map at the specified coordinates.
	 */
	public void addMapElement(MapElement element, MapCoordinate coordinate)/* throws OutOfBoundsException, OverlapException*/{
		
//		//check whether the placement is valid
//		if(checkOutOfBounds(element,coordinate))
//			throw new OutOfBoundsException();
//		if(checkOverlap(element,coordinate))
//			throw new OverlapException();
		
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

	@Override
	public Iterator<MapPlacement<? extends MapElement>> iterator() {
		return placements.iterator();
	}
}
