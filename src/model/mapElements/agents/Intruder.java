package model.mapElements.agents;

import model.geometry.Circular;
import model.geometry.Coordinate;

/**
 * Intruder agent
 * 
 * @author Stan, Robert
 *
 */
public class Intruder extends Agent {

	public Intruder(Coordinate coordinate){
		super( coordinate );
		//TODO: setConstants(???) with sprint
	}
	
	public Intruder(Circular shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
		// TODO Auto-generated constructor stub
	}
	
	
	public int LoadSettingsXML(String pathToXML){
		return -1;
	}
	/**
	  Sets all the basic constant variables including the sprint
	 * 
	 * @param maxSpeed The maximum speed of the robot in m/s
	 * @param maxAngle The maximum angle the robot can make in degrees/s
	 * @param visionAngle The vision angel of the robot in degrees
	 * @param maxVisionRange the maximum vision range of the robot in meters
	 * 
	 * @param maxSprintSpeed The maximum sprint speed in m/s
	 * @param maxSprintAngle The maximum angle the robot can make 
	 * @param maxSprintTime The maximum time that the robot can sprint
	 * @param sprintRest The time the robot needs to rest before it can sprint
	 */
	public void setConstants(
			double maxSpeed, double maxAngle, double visionAngle, 
			double minVisionRange, double maxVisionRange, double maxSprintSpeed, 
			double maxSprintAngle, double maxSprintTime, double sprintRest){
		m_maxMovingSpeed = maxSpeed;
		m_maxAngle = maxAngle;
		m_minVisionRange = minVisionRange;
		m_maxVisionRange = maxVisionRange;
		m_visionAngle = visionAngle;
		m_maxSprintSpeed = maxSprintSpeed;
		m_maxSprintAngle = maxSprintAngle;
		m_maxSprintTime = maxSprintTime;
		m_sprintRest = sprintRest;
	}
	
	
	/**
	 * @return the m_maxSprintSpeed
	 */
	public double getMaxSprintSpeed() {
		return m_maxSprintSpeed;
	}

	/**
	 * @return the m_maxSprintAngle
	 */
	public double getMaxSprintAngle() {
		return m_maxSprintAngle;
	}

	/**
	 * @return the m_maxSprintTime
	 */
	public double getMaxSprintTime() {
		return m_maxSprintTime;
	}

	/**
	 * @return the m_sprintRest
	 */
	public double getSprintRest() {
		return m_sprintRest;
	}
	
	protected double m_maxSprintSpeed;
	protected double m_maxSprintAngle;
	protected double m_maxSprintTime;
	protected double m_sprintRest;

}
