package model.mapElements.agents;

import model.geometry.Coordinate;

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
	
	/**
	 * 
	 * @return Coordinate representing the normal direction vector
	 */
	public Coordinate getDirectionCoordinate(){
		return new Coordinate(Math.cos(direction), Math.sin(direction));
	}
	
	
}
