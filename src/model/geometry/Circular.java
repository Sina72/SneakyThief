package model.geometry;


/**
 * Circular shape with a radius.
 * @author Stan
 *
 */
public class Circular extends Shape {

	private double radius; //in meters
	//i think we need a center coordinate/ for this!
	
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
