package model.mapElements.agents;

import model.geometry.Coordinate;

/**
 *A move that an agent can make, indicating a direction, a speed, and an angular speed.
 * 
 * @author Stan
 *
 */
public class Move {
	
	public Move(double direction, double speed, double rotationSpeed){
		this.direction = direction;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
	}
	
	public Move(double direction, double speed){
		this(direction,speed,0);
	}
	
	public Move(double rotationSpeed){
		this(0,0,rotationSpeed);
	}
	
	private double direction;
	private double speed;
	
	//rotation of an agent in speed. positive for counterclockwise rotation, negative for clockwise rotation. 
	//Speed in angular degrees per second
	private double rotationSpeed;
	
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
	
	/**
	 * 
	 * @return Coordinate representing the normal direction vector
	 */
	public Coordinate getDirectionCoordinate(){
		return new Coordinate(Math.cos(direction), Math.sin(direction));
	}

	/**
	 * @return the rotationSpeed
	 */
	public double getRotationSpeed() {
		return rotationSpeed;
	}

	/**
	 * @param rotationSpeed the rotationSpeed to set
	 */
	public void setRotationSpeed(double rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}
	
	
}
