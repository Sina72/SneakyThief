/**
 * 
 */
package model.mapElements.agents;

/**
 * @author ing. Robert Stevens
 *
 */
public class AgentConstants {
	public AgentConstants(double maxMovingSpeed, 
			double maxTurningSpeed,
			double minimalVisionRange, 
			double maximalVisionRange,
			double visionAngle,
			double sentryVisableRange,
			double structureVisableRange)
	{
		InitAgent( 	maxMovingSpeed, 
					maxTurningSpeed,
					minimalVisionRange, 
					maximalVisionRange,
					visionAngle,
					sentryVisableRange,
					structureVisableRange);
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
	
	protected void InitAgent(	double maxMovingSpeed, 
								double maxTurningSpeed,
								double minimalVisionRange, 
								double maximalVisionRange,
								double visionAngle,
								double sentryVisableRange,
								double structureVisableRange)
	{
		m_maxMovingSpeed = maxMovingSpeed;
		m_maxTurningSpeed = maxTurningSpeed;
		
		m_minVisionRange = minimalVisionRange;
		m_maxVisionRange = maximalVisionRange;
		m_visionAngle = visionAngle;

		m_senteryVisableRange = sentryVisableRange;	
		m_structureVisableRange = structureVisableRange;					
	}
	protected double m_maxMovingSpeed;
	protected double m_maxTurningSpeed;
	
	protected double m_minVisionRange;
	protected double m_maxVisionRange;
	protected double m_visionAngle;

	protected double m_structureVisableRange;
	protected double m_senteryVisableRange;

}
