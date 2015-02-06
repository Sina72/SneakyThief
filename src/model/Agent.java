package model;

/**
 * Basic class for the different agents
 * @author Stan, Robert
 *
 */
public class Agent extends MapElement {
	
	/**
	 * Default constructor
	 */
	public Agent(){
		//default values should be changed/ moved to XML?
		this(new Circular(0.25),0.0);
	}
	
	/**
	 * Constructor 
	 * @param shape Shape to represent the agent
	 * @param orientation Begin orientation of the agent in angular degrees counterclockwise
	 */
	public Agent(Shape shape, double orientation) {
		super(shape, orientation);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Sets all the basic constant variables, the sprint is switched off.
	 * 
	 * @param maxSpeed The maximum speed of the robot in m/s
	 * @param maxAngle The maximum angle the robot can make in degrees/s
	 * @param visionAngle The vision angel of the robot in degrees
	 * @param maxVisionRange the maximum vision range of the robot in meters
	 */
	public void setConstants(double maxSpeed, double maxAngle, double visionAngle,double minVisionRange, double maxVisionRange){
		m_maxMovingSpeed = maxSpeed;
		m_maxAngle = maxAngle;
		m_minVisionRange = minVisionRange;
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
	public void setConstants(double maxSpeed, double maxAngle, double visionAngle, double minVisionRange, double maxVisionRange, double maxSprintSpeed, double maxSprintAngle, double maxSprintTime, double sprintRest){
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
	
	private double m_maxMovingSpeed;
	private double m_maxAngle;
	//Vision range can also have minimum (see sentry description)
	private double m_minVisionRange;
	private double m_maxVisionRange;
	private double m_visionAngle;
	
	private double m_maxSprintSpeed;
	private double m_maxSprintAngle;
	private double m_maxSprintTime;
	private double m_sprintRest;
	
	
	private double m_movingSpeed;
	private double m_visionRange;
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

	/**
	 * @return the m_movingSpeed
	 */
	public double getMovingSpeed() {
		return m_movingSpeed;
	}

	/**
	 * @return the m_visionRange
	 */
	public double getVisionRange() {
		return m_visionRange;
	}
}
