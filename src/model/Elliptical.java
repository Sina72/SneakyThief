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
	 * @return width of the shape after rotation
	 */
	double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return height of the shape after rotation
	 */
	double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
