/**
 * 
 */
package model.mapElements.agents;

/**
 * @author ing. Robert Stevens
 *
 */
public class AgentConstants {
	public AgentConstants(){
		m_isInit = false;
	}
	
	public double getMaxMovingSpeed()
	{
		return m_maxMovingSpeed;
	}
	public double getMaxTurningSpeed()
	{
		return m_maxTurningSpeed;
	}
	public double getMinimalVisionRange()
	{
		return m_minVisionRange;
	}
	public double getMaximalVisionRange()
	{
		return m_maxVisionRange;
	}
	public double getVisionAngle()
	{
		return m_visionAngle;
	}
	public double getSentryVisableRange()
	{
		return m_structureVisableRange;
	}
	
	public double getStructureVisableRange()
	{
		return m_structureVisableRange;
	}
	
	public void InitAgent(	double maxMovingSpeed, 
								double maxTurningSpeed,
								double minimalVisionRange, 
								double maximalVisionRange,
								double visionAngle,
								double sentryVisableRange,
								double structureVisableRange)
	{
		if (m_isInit)
			return;
		m_isInit = true;
		m_maxMovingSpeed = maxMovingSpeed;
		m_maxTurningSpeed = maxTurningSpeed;
		
		m_minVisionRange = minimalVisionRange;
		m_maxVisionRange = maximalVisionRange;
		m_visionAngle = visionAngle;

		m_senteryVisableRange = sentryVisableRange;	
		m_structureVisableRange = structureVisableRange;					
	}
	private boolean m_isInit;
	private double m_maxMovingSpeed;
	private double m_maxTurningSpeed;
	
	private double m_minVisionRange;
	private double m_maxVisionRange;
	private double m_visionAngle;

	private double m_structureVisableRange;
	private double m_senteryVisableRange;

}
