package model;

/**
 * Elliptical shape with two radii.
 * @author Stan
 *
 */
public class Elliptical extends Shape {

	//width and height radius of the ellipse
	public double heightRadius, widthRadius; // in meters
	

	public Elliptical(double heightRadius, double widthRadius) {
		super();
		this.heightRadius = heightRadius;
		this.widthRadius = widthRadius;
	}

	/**
	 * @return width of the shape before rotation
	 */
	double getWidth() {
		return widthRadius*2;
	}

	/**
	 * @return height of the shape before rotation
	 */
	double getHeight() {
		return heightRadius*2;
	}

}
