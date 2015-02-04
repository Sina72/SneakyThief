package model;

/**
 * Circular shape with a radius.
 * @author Stan
 *
 */
public class Circular extends Shape {
	
	private double radius; //in meters

	@Override
	/**
	 * @return The maximum width of the shape
	 */
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * @return The maximum height in the shape
	 */
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 * @return radius of the shape
	 */
	public double getRadius() {
		return radius;
	}

}
