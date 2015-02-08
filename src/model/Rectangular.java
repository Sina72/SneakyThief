package model;

public class Rectangular extends Shape {

	//dimensions of the shape
	private double height, width; //in meters

	/**
	 * @return width of the shape (before rotation).
	 */
	double getWidth() {
		return width;
	}

	/**
	 * @return height of the shape (before rotation).
	 */
	double getHeight() {
		return height;
	}

	public Rectangular(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}


}
