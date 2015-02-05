package model;

/**
 * Basic class for the different agents
 * @author Stan, Robert
 *
 */
public class Agent extends MapElement {
	
	/**
	 * Sets all the basic constant variables, the sprint is switched off.
	 * 
	 * @param maxSpeed The maximum speed of the robot in m/s
	 * @param maxAngle The maximum angle the robot can make in degrees/s
	 * @param visionAngle The vision angel of the robot in degrees
	 * @param maxVisionRange the maximum vision range of the robot in meters
	 */
	public void setConstants(double maxSpeed, double maxAngle, double visionAngle, double maxVisionRange){
		m_maxMovingSpeed = maxSpeed;
		m_maxAngle = maxAngle;
		m_maxVisionRange = maxVisionRange;
		m_visionAngle = visionAngle;
		
		m_maxSprintSpeed = 0;
		m_maxSprintAngle = 0;
		m_maxSprintTime = 0;
		m_sprintRest = 0;
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
	public void setConstands(double maxSpeed, double maxAngle, double visionAngle, double maxVisionRange, double maxSprintSpeed, double maxSprintAngle, double maxSprintTime, double sprintRest){
		m_maxMovingSpeed = maxSpeed;
		m_maxAngle = maxAngle;
		m_maxVisionRange = maxVisionRange;
		m_visionAngle = visionAngle;
		m_maxSprintSpeed = maxSprintSpeed;
		m_maxSprintAngle = maxSprintAngle;
		m_maxSprintTime = maxSprintTime;
		m_sprintRest = sprintRest;
	}
	
	private double m_maxMovingSpeed;
	private double m_maxAngle;
	private double m_maxVisionRange;
	private double m_visionAngle;
	
	private double m_maxSprintSpeed;
	private double m_maxSprintAngle;
	private double m_maxSprintTime;
	private double m_sprintRest;
	
	
	private double m_movingSpeed;
	private double m_visionRange;
}
