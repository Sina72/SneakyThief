package model.geometry;


public class Rectangular extends Polygonal {


	public Rectangular(Coordinate... points) {
		super(points);
	}

	public Rectangular(double width, double height){
		this(new Coordinate(0,0), new Coordinate(width,height));
	}

}
