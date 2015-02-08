package model;

/**
 * Coordinate on the map. Should be in the left bottom corner of 
 * rectangular shaped elements and in the center of elliptical 
 * and circular shaped elements
 * @author Stan
 *
 */
public class MapCoordinate{
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
	
	/**
	 * 
	 * @return the distance of the coordinate from the origin
	 */
	public double absoluteValue(){
		return getDistance(new MapCoordinate(0,0), this);
	}
	
	public boolean equals(Object o){
		if(!(o instanceof MapCoordinate))
			return false;
		return 
				this.x == ((MapCoordinate) o).getX() && 
				this.y == ((MapCoordinate) o).getY();
	}
	
	public MapCoordinate minus(MapCoordinate c){
		return new MapCoordinate(x - c.x, y - c.y);
	}
	
	public MapCoordinate plus(MapCoordinate c){
		return new MapCoordinate(x + c.x, y + c.y);
	}
	
	public MapCoordinate divideBy(double p){
		return new MapCoordinate(x / p, y / p);
	}
	
	public double crossProduct(MapCoordinate c){
		return x * c.y - y * c.x;
	}
	
	public static double getDistance(
			MapCoordinate c1, 
			MapCoordinate c2) {
		return Math.sqrt(Math.pow(c1.x-c2.x,2)+Math.pow(c1.y-c2.y, 2));
	}

	/**
	 * 
	 * @param c1 coordinate one
	 * @param c2 coordinate two
	 * @return the angle between two coordinates
	 */
	public static double getAngle(
			MapCoordinate c1,
			MapCoordinate c2) {
		return Math.atan( (c2.y-c1.y) / (c2.x - c1.x) );
	}
}
