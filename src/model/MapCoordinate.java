package model;

/**
 * Coordinate on the map
 * @author Stan
 *
 */
public class MapCoordinate {
	private double x;
	private double y;
	
	
	public MapCoordinate(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	
	
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
}
