package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import model.exceptions.OutOfBoundsException;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.geometry.Rectangular;
import model.mapElements.MapPlacement;
import model.mapElements.Obstruction;
import model.mapElements.agents.Agent;
import model.mapElements.areas.Area;
import model.mapElements.areas.Sentry;

/**
 * Represents the map through which the agents move.
 * 
 * @author Stan
 *
 */
public class Map extends Observable implements Iterable<MapPlacement> {
	// Stores all elements and their coordinates. Coordinates are the left
	// bottom corner of the element.
	// Since Obstructions and Agents are keys, every obstruction or agent can
	// only occur once on the map.

	// list of all elements
	private List<MapPlacement> placements;

	// list of obstructions
	private List<Obstruction> obstructions;

	// list of agents
	private List<Agent> agents;

	// list of sentries
	private List<Sentry> sentries;

	// list of areas
	private List<Area> areas;

	// Dimensions of the map
	private double mapWidth, mapHeight;

	// constructor
	public Map(double width, double height) {
		mapWidth = width;
		mapHeight = height;
		placements = new ArrayList<MapPlacement>();
		obstructions = new ArrayList<Obstruction>();
		agents = new ArrayList<Agent>();
		areas = new ArrayList<Area>();
		sentries = new ArrayList<Sentry>();
	}

	// moves the agent to an input coordinate, stops at obstructions in the way.
	// by Sina
	// TODO: test classes
	public Obstruction move(Agent a, Coordinate destination) {

		// we create three view lines for the agent in order to check the
		// obstructions according to the agent's vision abilities.
		Coordinate aCoordinate = a.getCoordinate();
		double angleOfMove = Coordinate.getAngle(a.getCoordinate(), destination);
		double aVisionRange = a.getMaxVisionRange();
		double aRadius = a.getHeight() / 2;

		// I am not sure if the vision range is from the center of the agent ??
		Coordinate middleFront = aCoordinate.plus(new Coordinate(aVisionRange
				* Math.cos(angleOfMove), aVisionRange * Math.sin(angleOfMove)));
		Line middleSight = new Line(aCoordinate, middleFront);

		double maxCollisionsAngle = 2 * Math.asin(aRadius / aVisionRange);

		Coordinate leftFront = aCoordinate.plus(new Coordinate(aVisionRange
				* Math.cos(angleOfMove + maxCollisionsAngle), aVisionRange
				* Math.sin(angleOfMove + maxCollisionsAngle)));
		Line leftSight = new Line(aCoordinate, leftFront);

		Coordinate rightFront = aCoordinate.plus(new Coordinate(aVisionRange
				* Math.cos(angleOfMove - maxCollisionsAngle), aVisionRange
				* Math.sin(angleOfMove - maxCollisionsAngle)));
		Line rightSight = new Line(aCoordinate, rightFront);

		for (Obstruction o : obstructions) {
			if (o.intersects(new MapPlacement(middleSight,
					new Coordinate(0, 0), 0))
					|| o.intersects(new MapPlacement(rightSight,
							new Coordinate(0, 0), 0))
					|| o.intersects(new MapPlacement(leftSight, new Coordinate(
							0, 0), 0)))
				return o;
		}

		if (middleSight.liesOnLine(destination)) {
			a.move(destination);
			return null;
		}

		Coordinate nextStep = aCoordinate.plus(new Coordinate((aVisionRange - aRadius)
				* Math.cos(angleOfMove) , (aVisionRange - aRadius)
				* Math.sin(angleOfMove) ));

		a.move(nextStep);
		return move(a, destination);
	}

	// moves an agent without checking any obstructions
	// used for moving agents past permeable obstructions
	public void unobstructedMove(Agent a, Coordinate c) {
		a.move(c);
	}

	/**
	 * changes the orientation of an agent does not check for any conditions
	 * since agents are circular, so rotation is always valid
	 * 
	 * @param a
	 *            Agent to be rotated
	 * @param angle
	 *            The angle (in radians) of the rotation
	 */
	public void rotate(Agent a, double angle) {
		a.rotate(angle);
	}

	/**
	 * Returns all agents in view
	 * 
	 * @param agent
	 *            agent of which the view should be determined
	 * @return List<Agent> of all agents in view of Agent agent
	 */
	public List<Agent> getAgentsInView(Agent agent) {
		ArrayList<Agent> agentsInView = new ArrayList<Agent>();

		Iterator<Agent> it = agents.iterator();
		while (it.hasNext()) {
			Agent otherAgent = it.next();
			if (inView(agent, otherAgent.getCoordinate()))
				agentsInView.add(otherAgent);
		}

		return agentsInView;
	}

	/**
	 * gets all the obstructions that the agent can see in the form of a list of
	 * lines.
	 * 
	 * @param agent
	 *            Agent to be checked
	 * @return List of Obstructions that the agent can see
	 */
	public List<Obstruction> getObstructionsInView(Agent agent) {
		ArrayList<Obstruction> obstructionsInView = new ArrayList<Obstruction>();
		// TODO: implement a method that returns obstructions in view of an as
		// as few as possible separate lines.
		// different obstructions should be represented by different lines
		// the lines should maintain the properties of the obstruction, like
		// permeability.
		return obstructionsInView;
	}

	/**
	 * Checks whether a coordinate is in view of an agent
	 * 
	 * @param agent
	 *            agent of which the view should be determined
	 * @param coordinate
	 *            coordinate to check whether it is in view of the agent
	 * @return true if coordinate in view, false otherwise
	 */
	private boolean inView(Agent agent, Coordinate coordinate) {

		// TODO: shade implementation
		double orientation = agent.getOrientation();
		double visionAngle = agent.getVisionAngle();
		double maxVision = agent.getMaxVisionRange();
		double minVision = agent.getMinVisionRange();

		// checks within range
		Coordinate agentPosition = agent.getCoordinate();
		double distanceBetweenAgents = Coordinate.getDistance(agentPosition,
				coordinate);
		if (distanceBetweenAgents > maxVision
				|| distanceBetweenAgents < minVision)
			return false;

		// checks within view angle
		double angleBetweenAgents = Coordinate.getAngle(agentPosition,
				coordinate);
		if (angleBetweenAgents > orientation + visionAngle / 2
				|| angleBetweenAgents < orientation - visionAngle / 2)
			return false;

		// checks for obstructions
		Line viewLine = new Line(agentPosition, coordinate);
		for (Obstruction o : obstructions)
			if (o.intersects(new MapPlacement(viewLine, new Coordinate(0, 0), 0)))
				return false;

		return true;
	}

	/**
	 * Adds an Obstruction to t map
	 * 
	 * @param obstruction
	 *            The Obstruction to be added to the map
	 * @param coordinate
	 *            the Coordinate of the left bottom corner of the obstruction.
	 */
	private void addObstruction(Obstruction obstruction) {
		obstructions.add(obstruction);
		placements.add(obstruction);
	}

	/**
	 * Adds an area to the map
	 * 
	 * @param area
	 */
	public void addArea(Area area) {
		areas.add(area);
		placements.add(area);
	}

	/**
	 * Adds a sentry to the map
	 * 
	 * @param sentry
	 */
	public void addSentry(Sentry sentry) {
		sentries.add(sentry);
		placements.add(sentry);
	}

	/**
	 * Checks whether there is overlap between the specified and any existing
	 * MapElement
	 * 
	 * @param element
	 *            The element to be checked
	 * @param coordinate
	 *            At this coordinate
	 * @return
	 */
	private boolean checkOverlap(MapPlacement placement) {
		for (MapPlacement p : placements)
			if (p.intersects(placement))
				return true;
		return false;
	}

	/**
	 * Checks whether the MapElement would go out of bound at the specified
	 * Coordinate
	 * 
	 * @param element
	 *            MapElement that should be checked
	 * @param coordinate
	 *            The Coordinate at which the MapElement should be checked
	 * @return
	 */
	private boolean checkOutOfBounds(MapPlacement placement) {
		return placement.getCoordinate().getX() + placement.getWidth() > mapWidth
				|| // width is exceeded
				placement.getCoordinate().getY() + placement.getHeight() > mapHeight; // height
																						// is
																						// exceeded
	}

	/**
	 * Adds an Agent to the map
	 * 
	 * @param obstruction
	 *            The Agent to be added to the map
	 * @param coordinate
	 *            the Coordinate of the left bottom corner of the Agent.
	 * @throws OutOfBoundsException
	 *             if the Agent does not fit into the map at the speficied
	 *             coordinates
	 */
	private void addAgent(Agent agent) {
		agents.add(agent);
		placements.add(agent);
	}

	/**
	 * removes all agents from the map. Used for beliefMaps, where the agent
	 * might want to remove all its beliefs of where the other agents are from
	 * its internal map.
	 */
	public void rinseAgents() {
		for (Agent agent : agents)
			placements.remove(agent);
		agents.clear();
	}

	/**
	 * 
	 * @param element
	 *            The MapElement to be added to the map
	 * @param coordinate
	 *            the Coordinate of the left bottom corner of the MapElement
	 * @throws OutOfBoundsException
	 *             if the MapElement does not fit into the map at the specified
	 *             coordinates.
	 */
	public void addPlacement(MapPlacement placement)/*
													 * throws
													 * OutOfBoundsException,
													 * OverlapException
													 */{
		// TODO: Do we want these exceptions here? or maybe check this at the
		// mapBuilder?
		// check whether the placement is valid
		if (checkOutOfBounds(placement) || checkOverlap(placement))
			return;

		// call the right function based on MapElement type
		if (placement instanceof Obstruction)
			addObstruction((Obstruction) placement);
		else if (placement instanceof Agent)
			addAgent((Agent) placement);
		else {
			System.err.println("Invalid Plsacement");
		}
	}

	/**
	 * Remove Obstruction from the Map
	 * 
	 * @param obstruction
	 *            Obstruction to be removed.
	 */
	private void removeObstruction(Obstruction obstruction) {
		obstructions.remove(obstruction);
	}

	/**
	 * Remove Agent from the Map
	 * 
	 * @param agent
	 *            Agent to be removed
	 */
	private void removeAgent(Agent agent) {
		agents.remove(agent);
	}

	/**
	 * Remove MapElement from the Map
	 * 
	 * @param element
	 *            MapElement to be removed.
	 */
	public void removeMapElement(MapPlacement placement) {
		if (placement instanceof Obstruction)
			removeObstruction((Obstruction) placement);
		if (placement instanceof Agent)
			removeAgent((Agent) placement);
		else {
			System.err.println("Invalid MapElement");
		}
	}

	@Override
	public Iterator<MapPlacement> iterator() {
		return placements.iterator();
	}

	/**
	 * Iterates over the agents in the map
	 * 
	 * @return iterator over all the agents in the map
	 */
	public Iterator<Agent> agentIterator() {
		return agents.iterator();
	}

	/**
	 * Iterates over all the obstructions in the map
	 * 
	 * @return iterator over the obstructions in the map
	 */
	public Iterator<Obstruction> obstructionIterator() {
		return obstructions.iterator();
	}

	/**
	 * Iterates over all the areas in the map
	 * 
	 * @return iterator over the areas in the map.
	 */
	public Iterator<Area> areaIterator() {
		return areas.iterator();
	}

	/**
	 * Iterators over all the sentries in the map
	 * 
	 * @return iterator over the sentries in the map.
	 */
	public Iterator<Sentry> sentryIterator() {
		return sentries.iterator();
	}

}
