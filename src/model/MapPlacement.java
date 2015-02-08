package model;

import java.util.ArrayList;

public class MapPlacement<E extends Shape> {
	private E shape;
	private MapCoordinate coordinate;
	private double orientation;
	
	public MapPlacement(E shape, MapCoordinate coordinate, double orientation){
		this.shape = shape;
		this.coordinate = coordinate;
		this.orientation = orientation;
	}

	public MapCoordinate getMapCoordinate() {
		return coordinate;
	}
	
	public E getShape(){
		return shape;
	}
	
	public double  getOrientation(){
		return orientation;
	}
	
	public boolean intersects(MapPlacement<Shape> otherPlacement){
		Shape thisShape = shape;
		Shape otherShape = otherPlacement.getShape();
		
		if(thisShape instanceof Rectangular && otherShape instanceof Rectangular)
			return intersectRectRect(
					this, 
					otherPlacement
					);
		
		if(thisShape instanceof Circular && otherShape instanceof Circular)
			return intersectCircCirc(this, otherPlacement);
		
		if(thisShape instanceof Line && otherShape instanceof Line)
			return intersectLineLine(this, otherPlacement);
		
		
		return false;
	}

	private static boolean intersectCircCirc(MapPlacement placement, MapPlacement otherPlacement) {
		return 
				MapCoordinate.getDistance(placement.getMapCoordinate(), otherPlacement.getMapCoordinate()) //distance between circle centers
				< 
				(((Circular) placement.getShape()).getRadius() + //radius this circle
						((Circular) otherPlacement.getShape()).getRadius()); //radius other circle
	}

	private static boolean intersectLineLine(MapPlacement placement, MapPlacement otherPlacement) {
		
		MapCoordinate p = placement.getMapCoordinate().plus(((Line) placement.getShape()).getBegin());
		MapCoordinate r = ((Line) placement.getShape()).getEnd();
		
		MapCoordinate q = otherPlacement.getMapCoordinate().plus(((Line) otherPlacement.getShape()).getBegin());
		MapCoordinate s = ((Line) otherPlacement.getShape()).getEnd();
		
		MapCoordinate qMinP = q.minus(p);
		double rCrossS = r.crossProduct(s);
		
		if(rCrossS == 0)
			return false;
		
		double t = qMinP.crossProduct(s.divideBy(rCrossS));
		double u = qMinP.crossProduct(s.divideBy(rCrossS)); 
		
		if(t <= 1 && t >= 0 && u <= 1 && u >= 0)
			return true;
		
		return false;
	}

	private static boolean intersectRectRect(MapPlacement placement, MapPlacement otherPlacement) {
		ArrayList<Line> r1 = new ArrayList<Line>();
		ArrayList<Line> r2 = new ArrayList<Line>();

		
		Rectangular r1Shape = (Rectangular) placement.getShape();
		Rectangular r2Shape = (Rectangular) otherPlacement.getShape();
		
		
		MapCoordinate leftBottom, rightBottom, rightTop, leftTop;
		
		leftBottom = placement.getMapCoordinate();
		rightBottom = leftBottom.plus(
				new MapCoordinate(
						r1Shape.getWidth()*Math.cos(placement.orientation),
						r1Shape.getWidth()*Math.sin(placement.orientation))
				);
//		leftTop = leftBottom.plus(
//				new MapCoordinate(
//						r1Shape.getHeight()
//						
//						)
//				);
		
		
		return false;
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
