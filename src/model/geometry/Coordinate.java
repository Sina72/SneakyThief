package model.geometry;

/**
 * Coordinate on the map. Should be in the left bottom corner of 
 * rectangular shaped elements and in the center of elliptical 
 * and circular shaped elements
 * @author Stan
 *
 */
public class Coordinate{
	private double x;
	private double y;
	
	
	public Coordinate(double x, double y) {
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
	
	/**
	 * 
	 * @return the distance of the coordinate from the origin
	 */
	public double absoluteValue(){
		return getDistance(new Coordinate(0,0), this);
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Coordinate))
			return false;
		return 
				this.x == ((Coordinate) o).getX() && 
				this.y == ((Coordinate) o).getY();
	}
	
	public Coordinate minus(Coordinate c){
		return new Coordinate(x - c.x, y - c.y);
	}
	
	public Coordinate plus(Coordinate c){
		return new Coordinate(x + c.x, y + c.y);
	}
	
	public Coordinate divideBy(double p){
		return new Coordinate(x / p, y / p);
	}
	
	public double determinant(Coordinate c){
		return x * c.y - y * c.x;
	}
	
	public static double getDistance(
			Coordinate c1, 
			Coordinate c2) {
		return Math.sqrt(Math.pow(c1.x-c2.x,2)+Math.pow(c1.y-c2.y, 2));
	}

	/**
	 * 
	 * @param c1 coordinate one
	 * @param c2 coordinate two
	 * @return the angle between two coordinates
	 */
	public static double getAngle(
			Coordinate c1,
			Coordinate c2) {
		return Math.atan( (c2.y-c1.y) / (c2.x - c1.x) );
	}
	
	
}
