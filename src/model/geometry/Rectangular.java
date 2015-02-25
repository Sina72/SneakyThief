
package model.geometry;


public class Rectangular extends Polygonal {


	public Rectangular(Coordinate leftBottom, Coordinate rightTop) {
		super(
				new Coordinate(leftBottom.getX(),leftBottom.getY()),
				new Coordinate(rightTop.getX(),leftBottom.getY()),
				new Coordinate(rightTop.getX(),rightTop.getY()),
				new Coordinate(leftBottom.getX(),rightTop.getY())
				);
	}
	
	public Rectangular(Coordinate rightTop){
		this(new Coordinate(0,0), rightTop);
	}

	public Rectangular(double width, double height){
		this(new Coordinate(width,height));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
