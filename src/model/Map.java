package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import model.exceptions.OutOfBoundsException;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.mapElements.Agent;
import model.mapElements.MapPlacement;
import model.mapElements.Obstruction;

/**
 * Represents the map through which the agents move.
 * @author Stan
 *
 */
public class Map extends Observable implements Iterable<MapPlacement> {
	//Stores all elements and their coordinates. Coordinates are the left bottom corner of the element.
	//Since Obstructions and Agents are keys, every obstruction or agent can only occur once on the map.
	
	private List<MapPlacement> placements;

	public List<MapPlacement> getPlacements() {
		return placements;
	}

	public void setPlacements(List<MapPlacement> placements) {
		this.placements = placements;
	}

	public List<Obstruction> getObstructions() {
		return obstructions;
	}

	public void setObstructions(List<Obstruction> obstructions) {
		this.obstructions = obstructions;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	private List<Obstruction> obstructions;
	private List<Agent> agents;

	//Dimensions of the map
	private double mapWidth, mapHeight;
	
	public Map(double width, double height){
		mapWidth = width;
		mapHeight = height;
		placements = new ArrayList<MapPlacement>();
		obstructions = new ArrayList<Obstruction>();
		agents = new ArrayList<Agent>();
	}
	
	/**
	 * Returns all agents in view
	 * @param agent agent of which the view should be determined
	 * @return List<Agent> of all agents in view of Agent agent
	 */
	public List<Agent> getInView(Agent agent){
		ArrayList<Agent> agentsInView = new ArrayList<Agent>();
		
		Iterator<Agent> it = agents.iterator();
		while(it.hasNext()){
			Agent otherAgent = it.next();
			if(inView(agent, otherAgent.getCoordinate()))
				agentsInView.add(otherAgent);
		}

		return agentsInView;
	}
	
	/**
	 * Checks whether a coordinate is in view of an agent
	 * @param agent agent of which the view should be determined
	 * @param coordinate coordinate to check whether it is in view of the agent
	 * @return true if coordinate in view, false otherwise
	 */
	private boolean inView(Agent agent, Coordinate coordinate){
		
		double orientation = agent.getOrientation();
		double visionAngle = agent.getVisionAngle();
		double maxVision = agent.getMaxVisionRange();
		double minVision = agent.getMinVisionRange();
		
		//checks within range
		Coordinate agentPosition = agent.getCoordinate();
		double distanceBetweenAgents = Coordinate.getDistance(agentPosition, coordinate);
		if(
				distanceBetweenAgents > maxVision || 
				distanceBetweenAgents < minVision)
			return false;
		
		//checks within view angle
		double angleBetweenAgents = Coordinate.getAngle(agentPosition,coordinate);
		if( 
				angleBetweenAgents > orientation + visionAngle / 2 || 
				angleBetweenAgents < orientation - visionAngle / 2)
			return false;
		
		//checks for obstructions
		Line viewLine = new Line(agentPosition, coordinate);
		for(Obstruction o : obstructions)
			if(o.intersects(new MapPlacement(viewLine,new Coordinate(0,0),0)))
				return false;
		
		return true;
	}
	
	
	/**
	 * Adds an Obstruction to t map
	 * @param obstruction The Obstruction to be added to the map
	 * @param coordinate the Coordinate of the left bottom corner of the obstruction.
	 */
	private void addObstruction(Obstruction obstruction){
		obstructions.add(obstruction);
		placements.add(obstruction);
	}
	
	/**
	 * Checks whether there is overlap between the specified and any existing MapElement
	 * @param element The element to be checked
	 * @param coordinate At this coordinate
	 * @return
	 */
	private boolean checkOverlap(MapPlacement placement) {
		for(MapPlacement p : placements)
			if(p.intersects(placement))
				return true;
		return false;
	}

	/**
	 * Checks whether the MapElement would go out of bound at the specified Coordinate
	 * @param element MapElement that should be checked
	 * @param coordinate The Coordinate at which the MapElement should be checked
	 * @return
	 */
	private boolean checkOutOfBounds(MapPlacement placement) {
		return 
				placement.getCoordinate().getX() + placement.getWidth() > mapWidth || // width is exceeded
				placement.getCoordinate().getY() + placement.getHeight() > mapHeight; // height is exceeded
	}
	
	/**
	 * Adds an Agent to the map
	 * @param obstruction The Agent to be added to the map
	 * @param coordinate the Coordinate of the left bottom corner of the Agent.
	 * @throws OutOfBoundsException if the Agent does not fit into the map at the speficied coordinates
	 */
	private void addAgent(Agent agent){
		agents.add(agent);
		placements.add(agent);
	}
	
	public void rinseAgents(){
		for(Agent agent : agents )
			placements.remove(agent);
		agents.clear();
	}
	
	/**
	 * 
	 * @param element The MapElement to be added to the map
	 * @param coordinate the Coordinate of the left bottom corner of the MapElement
	 * @throws OutOfBoundsException if the MapElement does not fit into the map at the specified coordinates.
	 */
	public void addPlacement(MapPlacement placement)/* throws OutOfBoundsException, OverlapException*/{
		
		//check whether the placement is valid
		if(checkOutOfBounds(placement) || checkOverlap(placement))
			return;
		
		//call the right function based on MapElement type
		if(placement instanceof Obstruction)
			addObstruction((Obstruction) placement);
		else if(placement instanceof Agent)
			addAgent((Agent) placement);
		else{
			System.err.println("Invalid Plsacement");
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
	public void removeMapElement(MapPlacement placement){
		if(placement instanceof Obstruction)
			removeObstruction((Obstruction) placement);
		if(placement instanceof Agent)
			removeAgent((Agent) placement);
		else{
			System.err.println("Invalid MapElement");
		}
	}

	@Override
	public Iterator<MapPlacement> iterator() {
		return placements.iterator();
	}

}
