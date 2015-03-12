package model.mapElements.agents;

import java.util.ArrayList;
import java.util.HashMap;

import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Shape;
import model.mapElements.MapPlacement;
import model.xmlReader.XMLReader;

/**
 * Intruder agent
 * 
 * @author Stan, Robert
 *
 */
public class Intruder extends Agent {

	
	public Intruder(Coordinate coordinate){
		this(Agent.DEFAULT_AGENT_SHAPE,coordinate, MapPlacement.DEFAULT_ORIENTATION);
		//TODO: setConstants(???) with sprint
	}
	
	public Intruder(Shape shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
		// TODO Auto-generated constructor stub
	}
	
	
	public int LoadSettingsXML(String pathToXML){
		XMLReader reader = new XMLReader();
		reader.setXmlFileName(pathToXML);
		reader.OpenXML();
		reader.ReadType("intruder");
		ArrayList<HashMap<String, String>> settingsList;
		settingsList = reader.GetHashMapArray();
		if (settingsList.size() != 1)
		{
			return -3;
		}
		HashMap<String, String> settings = settingsList.get(0);
		
		setConstants(settings);
		m_maxSprintSpeed =  ToDouble(settings.get("sprintSpeed"));
		m_maxSprintAngle =  ToDouble(settings.get("sprintTime"));
		m_maxSprintTime =  ToDouble(settings.get("sprintTime"));
		m_sprintRest =  ToDouble(settings.get("sprintRest"));
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
