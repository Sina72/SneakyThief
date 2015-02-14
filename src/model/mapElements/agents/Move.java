package model.mapElements.agents;

public class Move {
	
	public Move(double direction, double speed){
		this.direction = direction;
		this.speed = speed;
	}
	
	private double direction;
	private double speed;
	
	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}
	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
}
