package model.mapElements.agents;

import java.util.ArrayList;
import java.util.HashMap;

import model.xmlReader.*;
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
		XMLReader reader = new XMLReader();
		reader.setXmlFileName("agents.xml");
		reader.OpenXML();
		reader.ReadType("surveillance");
		ArrayList<HashMap<String, String>> settingsList;
		settingsList = reader.GetHashMapArray();
		if (settingsList.size() != 1)
		{
			return -3;
		}
		HashMap<String, String> settings = settingsList.get(0);
		
		ToDouble(settings.get(""));
		return -1;
	}
	
	public void enterSentry(){
		//TODO sleep ()
		m_currentSpeed = 0;
		m_currentAngle = m_sentryViewAngle;
		m_currentMaxVisionRange = m_sentryMaxViewRange;
		m_currentMinVisionRange = m_sentryMinViewRange;
	}
	
	public void leaveSentry(){
		//TODO sleep()
		m_currentSpeed = 0;
		m_currentAngle = m_maxAngle;
		m_currentMaxVisionRange = m_maxVisionRange;
		m_currentMinVisionRange = m_minVisionRange;
	}

	
	protected double m_sentryMaxViewRange;
	protected double m_sentryMinViewRange;
	protected double m_sentryViewAngle;

	private double ToDouble(String text)
	{
		return Double.parseDouble(text);
	}
	protected double m_senteryMaxVieuwRange;
	protected double m_senteryMinVieuwRange;
	protected double m_senteryVieuwAngle;
	
}
