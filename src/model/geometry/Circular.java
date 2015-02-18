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
	
	/**
	 * @return the coordinate of edge of circle at given angle from the centre of the circle
	 * 
	 */
	public Coordinate getEdgeCoordinate(double angle) {
		Coordinate edge = new Coordinate(Math.round(radius * Math.cos(angle)),Math.round(radius * Math.sin(angle)));
		return edge;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circular)
			return super.equals(obj) && ((Circular) obj).radius == this.radius;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
