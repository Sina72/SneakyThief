/**
 * 
 */
package model.mapElements.agents;

import model.Map;

/**
 * @author ing. Robert Stevens
 *
 */
public class AgentVariable {
	AgentVariable()
	{
	}
	
	private double m_currentMovementSpeed;
	private double m_currentTurnSpeed;
	private double m_currentAngle;
	private double m_currentDirection;
	private double m_currentMaxVisionRange;
	private double m_currentMinVisionRange;
	private boolean m_currentIsHidden;
	
	private Map beliefMap;

}
