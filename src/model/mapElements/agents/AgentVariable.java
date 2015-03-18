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
	AgentVariable(AgentConstants constants)
	{
		m_constants = constants;
	}
	
	
	
	public double getMovementSpeed() {
		return m_currentMovementSpeed;
	}

	public void setMovementSpeed(double speed) {
		if(m_currentMovementSpeed > m_constants.getMaxMovingSpeed()){
			speed = m_constants.getMaxMovingSpeed();
		}
		this.m_currentMovementSpeed = speed;
	}



	public double getTurnSpeed() {
		return m_currentTurnSpeed;
	}



	public void setTurnSpeed(double turnSpeed) {
		if(m_currentTurnSpeed > m_constants.getMaxTurningSpeed()){
			turnSpeed = m_constants.getMaxTurningSpeed();
		}
		this.m_currentTurnSpeed = turnSpeed;
	}



	public double getAngle() {
		return m_currentAngle;
	}



	public void setAngle(double angle) {
		if (angle > 2*Math.PI)
			angle = angle % 2*Math.PI;
		this.m_currentAngle = angle;
	}



	public double getDirection() {
		return m_currentDirection;
	}



	public void setDirection(double direction) {
		if (direction > 2*Math.PI)
			direction = direction % 2*Math.PI;
		this.m_currentDirection = direction;
	}



	public double getMaxVisionRange() {
		return m_currentMaxVisionRange;
	}



	public void setMaxVisionRange(double visionRange) {
		if(visionRange > m_constants.getMaximalVisionRange()){
			visionRange = m_constants.getMaximalVisionRange();
		}
		this.m_currentMaxVisionRange = visionRange;
	}



	public double getMinVisionRange() {
		return m_currentMinVisionRange;
	}



	public void setMinVisionRange(double visionRange) {
		if(visionRange > m_constants.getMinimalVisionRange()){
			visionRange = m_constants.getMinimalVisionRange();
		}
		this.m_currentMaxVisionRange = visionRange;
	}



	public boolean isIsHidden() {
		return m_currentIsHidden;
	}



	public void setIsHidden(boolean m_currentIsHidden) {
		this.m_currentIsHidden = m_currentIsHidden;
	}



	public Map getBeliefMap() {
		return beliefMap;
	}



	public void setBeliefMap(Map beliefMap) {
		this.beliefMap = beliefMap;
	}



	private double m_currentMovementSpeed;
	private double m_currentTurnSpeed;
	private double m_currentAngle;
	private double m_currentDirection;
	private double m_currentMaxVisionRange;
	private double m_currentMinVisionRange;
	private boolean m_currentIsHidden;
	
	private AgentConstants m_constants;
	
	private Map beliefMap;

}
