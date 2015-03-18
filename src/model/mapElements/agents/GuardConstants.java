package model.mapElements.agents;

public class GuardConstants extends AgentConstants{

	public GuardConstants(){
		m_isInitGuard = false;
	}
	
	public void InitGuard(	double maxMovingSpeed, 
			double maxTurningSpeed,
			double minimalVisionRange, 
			double maximalVisionRange,
			double visionAngle,
			double sentryVisableRange,
			double structureVisableRange,
			double sentryMaxVieuwRange,
			double sentryMinVieuwRange,
			double sentryViewAngle,
			double sentryTurnSpeed)
			{
				if (m_isInitGuard)
					return;
				m_isInitGuard = true;
				InitAgent(	maxMovingSpeed, 
							maxTurningSpeed,
							minimalVisionRange, 
							maximalVisionRange,
							visionAngle,
							sentryVisableRange,
							structureVisableRange);
				m_sentryMaxViewRange = sentryMaxVieuwRange;
				m_sentryMinViewRange = sentryMinVieuwRange;
				m_sentryViewAngle = sentryViewAngle;
				m_sentryTurnSpeed = sentryTurnSpeed;
				
			}
	public double getSentryMaxVieuwRange()
	{
		return m_sentryMaxViewRange;
	}
	public double getSentryMinVieuwRange()
	{
		return m_sentryMinViewRange;
	}
	public double getSentryViewAngle()
	{
		return m_sentryViewAngle;
	}
	public double getSentryTurnSpeed()
	{
		return m_sentryTurnSpeed;
	}
	private boolean m_isInitGuard;
	private double m_sentryMaxViewRange;
	private double m_sentryMinViewRange;
	private double m_sentryViewAngle;
	private double m_sentryTurnSpeed;
}
