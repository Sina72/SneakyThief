package model.mapElements.agents;

import model.geometry.Circular;
import model.geometry.Coordinate;

/**
 * The guard agents.
 * 
 * @author Stan, Robert
 *
 */
public class Guard extends Agent {

	public Guard(Coordinate coordinate){
		super(coordinate);
		//TODO: setConstants(????)
	}
	
	public Guard(Circular shape, Coordinate coordinate, double orientation) {
		super(shape,coordinate, orientation);
	}
	
	public int LoadSettingsXML(String pathToXML){
		return -1;
	}
	
	public void enterSentry(){
		//TODO sleep ()
		m_currentSpeed = 0;
		m_currentAngle = m_senteryVieuwAngle;
		m_currentMaxVisionRange = m_senteryMaxVieuwRange;
		m_currentMinVisionRange = m_senteryMinVieuwRange;
	}
	
	public void leaveSentry(){
		//TODO sleep()
		m_currentSpeed = 0;
		m_currentAngle = m_maxAngle;
		m_currentMaxVisionRange = m_maxVisionRange;
		m_currentMinVisionRange = m_minVisionRange;
	}
	
	protected double m_senteryMaxVieuwRange;
	protected double m_senteryMinVieuwRange;
	protected double m_senteryVieuwAngle;
	
}
