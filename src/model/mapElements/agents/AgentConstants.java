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
			double maxTurnSpeed,
			double minimalVisionRange, 
			double maximalVisionRange,
			double visionAngle,
			double sentryVisableRange,
			double structureVisableRange)
	{
		InitAgent( 	maxMovingSpeed, 
					maxTurnSpeed,
					minimalVisionRange, 
					maximalVisionRange,
					visionAngle,
					sentryVisableRange,
					structureVisableRange);
	}
	
	public double getMaxMovementSpeed()
	{
		return m_maxMovingSpeed;
	}
	protected void InitAgent(	double maxMovingSpeed, 
								double maxTurnSpeed,
								double minimalVisionRange, 
								double maximalVisionRange,
								double visionAngle,
								double sentryVisableRange,
								double structureVisableRange)
	{
		m_maxMovingSpeed = maxMovingSpeed;
		m_maxTurningSpeed = maxTurnSpeed;
		
		m_minVisionRange = minimalVisionRange;
		m_maxVisionRange = maximalVisionRange;
		m_visionAngle = visionAngle;

		m_structureVisableRange = structureVisableRange;
		m_senteryVisableRange = sentryVisableRange;						
	}
	protected double m_maxMovingSpeed;
	protected double m_maxTurningSpeed;
	
	protected double m_minVisionRange;
	protected double m_maxVisionRange;
	protected double m_visionAngle;

	protected double m_structureVisableRange;
	protected double m_senteryVisableRange;

}
