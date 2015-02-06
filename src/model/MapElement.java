package model;

/**
 * Common structure for elements that can be put onto the map.
 * @author Stan
 *
 */
public abstract class MapElement {
	//shape of the mapElement
	private double orientation;
	private Shape shape;
	
	public MapElement(Shape shape, double orientation){
		this.shape = shape;
		this.orientation = orientation;
	}

	public void setOrientation(double value) {
		this.orientation = value;
	}
	
	/**
	 * Rotates the MapElement with a certain amount of degrees (counterclockwise)
	 * @param value
	 */
	public void rotate(double value){
		this.orientation += value;
	}

	public double getOrientation() {
		return this.orientation;
	}
	
	/**
	 * 
	 * @return width after rotation
	 */
	public double getWidth() {
		double shapeWidth = shape.getWidth();
		return Math.cos(orientation) * shapeWidth;
	}
	
	/**
	 * 
	 * @return height after rotation
	 */
	public double getHeight() {
		double shapeHeight = shape.getHeight();
		return Math.sin(orientation) * shapeHeight;
	}

	
}
