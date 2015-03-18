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
	protected boolean m_isInitGuard;
	protected double m_sentryMaxViewRange;
	protected double m_sentryMinViewRange;
	protected double m_sentryViewAngle;
	protected double m_sentryTurnSpeed;
}
