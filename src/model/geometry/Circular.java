package model.geometry;


/**
 * Circular shape with a radius.
 * @author Stan
 *
 */
public class Circular extends Shape {

	private double radius; //in meters

	public Circular(double radius) {
		super();
		this.radius = radius;
	}

	/**
	 * 
	 * @return radius of the shape
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public double getWidth() {
		return radius*2;
	}

	@Override
	public double getHeight() {
		return radius*2;
	}
}