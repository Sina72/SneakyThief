package model.mapElements.agents;

import java.util.List;
import java.util.Random;

import model.Map;
import model.geometry.Circular;
import model.geometry.Coordinate;
import model.mapElements.MapPlacement;


/**
 * Basic class for the different agents
 * @author Stan, Robert
 *
 */
public class Agent extends MapPlacement {
	
	private static int idCounter = 0;
	
	private int id;
	
	/**
	 * Default constructor
	 */
	public Agent(Coordinate coordinate){
		//default values should be changed/ moved to XML?
		this(new Circular(2),coordinate,0.0);
	}
	
	/**
	 * Constructor 
	 * @param shape Shape to represent the agent
	 * @param orientation Begin orientation of the agent in angular degrees counterclockwise
	 */
	public Agent(Circular shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
		beliefMap = new Map(this.getWidth(),super.getHeight());
		this.id = ++idCounter;
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * Inform the agent about placements it can see. It should only be able to see obstructions as lines, but agents as a whole.
	 * @param placements
	 */
	public void inform( List<? extends MapPlacement> placements ){
		beliefMap.rinseAgents();
		for(MapPlacement placement : placements){
				beliefMap.addPlacement(placement);
		//TODO: finish inform method. Agents and obstructions should be put on the map
		}
	}
	
	/**
	 * Gets the move the agent wants to make
	 * @return Move that the agent wants to make
	 */
	public Move getMove(){
		//make a random move (random direction, random speed, and random rotation)
		Random r = new Random();
		return new Move(
				r.nextDouble()*2*Math.PI, // random direction
				r.nextDouble()*this.m_maxMovingSpeed, //random moving speed
				r.nextDouble()*this.m_maxAngle*2 - this.m_maxAngle //random rotation speed
				);
	}
	
	/**
	 * overwrite this function is the classes witch extend this one
	 * @param pathToXML The path to the xml file
	 * @return 0 on success -1 if not overwritten -2 if file does not exist -3 if incorrect file 
	 */
	public int LoadSettingsXML(String pathToXML){
		return -1;
	}
	/**
	 * Sets all the basic constant variables, the sprint is switched off.
	 * 
	 * @param maxSpeed The maximum speed of the robot in m/s
	 * @param maxAngle The maximum angle the robot can make in degrees/s
	 * @param visionAngle The vision angel of the robot in degrees
	 * @param maxVisionRange the maximum vision range of the robot in meters
	 */
	public void setConstants(
			double maxSpeed, double maxAngle, double visionAngle,
			double minVisionRange, double maxVisionRange){
		m_maxMovingSpeed = maxSpeed;
		m_maxAngle = maxAngle;
		m_minVisionRange = minVisionRange;
		m_maxVisionRange = maxVisionRange;
		m_visionAngle = visionAngle;
	}
	
	protected double m_maxMovingSpeed;
	protected double m_maxAngle;
	protected double m_minVisionRange;
	protected double m_maxVisionRange;
	protected double m_visionAngle;
	
	protected double m_visionRange;
	
	protected double m_wallVisableRange;
	protected double m_senteryVisableRange;
	
	protected double m_currentSpeed;
	protected double m_currentAngle;
	protected double m_currentMaxVisionRange;
	protected double m_currentMinVisionRange;
	protected boolean m_isHidden;
	
	protected Map beliefMap;
	
	public double getM_currentSpeed() {
		return m_currentSpeed;
	}


	public double getM_currentAngle() {
		return m_currentAngle;
	}


	public double getM_currentMaxVisionRange() {
		return m_currentMaxVisionRange;
	}

	public double getM_currentMinVisionRange() {
		return m_currentMinVisionRange;
	}
	
	/**
	 * @return the m_maxMovingSpeed
	 */
	public double getMaxMovingSpeed() {
		return m_maxMovingSpeed;
	}

	/**
	 * @return the m_maxAngle
	 */
	public double getMaxAngle() {
		return m_maxAngle;
	}

	/**
	 * @return the m_minVisionRange
	 */
	public double getMinVisionRange() {
		return m_minVisionRange;
	}

	/**
	 * @return the m_maxVisionRange
	 */
	public double getMaxVisionRange() {
		return m_maxVisionRange;
	}

	/**
	 * @return the m_visionAngle
	 */
	public double getVisionAngle() {
		return m_visionAngle;
	}


	/**
	 * @return the m_visionRange
	 */
	public double getVisionRange() {
		return m_visionRange;
	}
	
	public String toString(){
		return "ID: " + id + " Position: " + super.getCoordinate().toString();
	}
}
