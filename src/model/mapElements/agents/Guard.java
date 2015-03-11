package model.mapElements.agents;

import java.util.ArrayList;
import java.util.HashMap;

import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Shape;
import model.mapElements.MapPlacement;
import model.xmlReader.XMLReader;

/**
 * The guard agents.
 * 
 * @author Stan, Robert
 *
 */
public class Guard extends Agent {

	public Guard(Coordinate coordinate){
		this(Agent.DEFAULT_AGENT_SHAPE,coordinate,MapPlacement.DEFAULT_ORIENTATION);
	}
	
	public Guard(Shape shape, Coordinate coordinate, double orientation) {
		super(shape,coordinate, orientation);
	}
	
	public int LoadSettingsXML(String pathToXML){
		XMLReader reader = new XMLReader();
		reader.setXmlFileName(pathToXML);
		reader.OpenXML();
		reader.ReadType("surveillance");
		ArrayList<HashMap<String, String>> settingsList;
		settingsList = reader.GetHashMapArray();
		if (settingsList.size() != 1)
		{
			return -3;
		}
		HashMap<String, String> settings = settingsList.get(0);
		
		setConstants(settings);
		m_sentryMaxViewRange = ToDouble(settings.get("maxTowerVisionRange"));
		m_sentryMinViewRange = ToDouble(settings.get("minTowerVisionRange"));
		m_sentryViewAngle = ToDouble(settings.get("towerVieuwAngle"));
		m_sentryTurnSpeed = ToDouble(settings.get("towerMaxTurningAngle"));
		return -1;
	}
	
	public void enterSentry(){
		//TODO sleep ()
		m_currentSpeed = 0;
		m_currentAngle = m_sentryViewAngle;
		m_currentMaxVisionRange = m_sentryMaxViewRange;
		m_currentMinVisionRange = m_sentryMinViewRange;
		m_currentTurnSpeed = m_sentryTurnSpeed;
	}
	
	public void leaveSentry(){
		//TODO sleep()
		m_currentSpeed = 0;
		m_currentAngle = m_maxAngle;
		m_currentMaxVisionRange = m_maxVisionRange;
		m_currentMinVisionRange = m_minVisionRange;
		m_currentTurnSpeed = m_maxAngle;
	}

	
	protected double m_sentryMaxViewRange;
	protected double m_sentryMinViewRange;
	protected double m_sentryViewAngle;
	protected double m_sentryTurnSpeed;
	
}
