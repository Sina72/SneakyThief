package model.mapElements;

import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.geometry.Shape;
import model.mapElements.areas.Area;


public class MapPlacement {
	public static final double DEFAULT_ORIENTATION = 0;
	private Shape shape;
	private Coordinate coordinate;
	private double orientation;
	
	/**
	 * Constructor
	 * @param shape Shape that the placement is supposed to take
	 * @param coordinate The coordinate of the placement (left bottom corner for all shapes except circles)
	 * @param orientation The rotation of the placement counterclockwise in radians; zero points to the right
	 */
	public MapPlacement(Shape shape, Coordinate coordinate, double orientation){
		this.shape = shape;
		this.coordinate = coordinate;
		this.orientation = orientation;
	}

	/**
	 * 
	 * @return Coordinate of the placement (center for circular and left bottom corner otherwise)
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * 
	 * @return Shape of the placement
	 */
	public Shape getShape(){
		return shape;
	}
	
	/**
	 * Orientation of the placement in angular degrees, counterclockwise.
	 * @return orientation of the placement
	 */
	public double  getOrientation(){
		return orientation;
	}
	
	/**
	 * Checks whether the placement intersects with the other placement
	 * TODO: Fix Bug : it does not take into account the orientation of the MapPlacement.
	 * @param otherPlacement
	 * @return true if they intersect, false otherwise
	 */
	public boolean intersects(MapPlacement otherPlacement){
		Shape thisShape = shape;
		Shape otherShape = otherPlacement.getShape();
		
		//works for two polygons, including lines and rectangles
		if(thisShape instanceof Polygonal && otherShape instanceof Polygonal)
			return intersectPolyPoly( this, otherPlacement);
		
		//works for one polygon (inc. line) and a circle
		if(thisShape instanceof Polygonal && otherShape instanceof Circular)
			return intersectCircPoly( otherPlacement, this );
		if(thisShape instanceof Circular && otherShape instanceof Polygonal)
			return intersectCircPoly( this, otherPlacement );
		
		//works for two circles
		if(thisShape instanceof Circular && otherShape instanceof Circular)
			return intersectCircCirc(this, otherPlacement);
		
		return false;
	}
	
	/**
	 * Moves the placement
	 * @param c Relative Coordinate
	 */
	public void move(Coordinate c){
		this.coordinate = this.coordinate.plus(c);
	}
	
	/**
	 * 
	 * @param angle 
	 */
	public void rotate(double angle){
		this.orientation += angle;
	}
	
	/**
	 * Checks whether there is overlap between an placement and an area. Can be used to check whether an agent 
	 * is in the shade or outside, but also to check for other MapPlacements such as sentries.
	 * 
	 * @param placement the placement to be checked
	 * @param area The area to be checked
	 * @return true if the placement has overlap with the area, false otherwise
	 */
	private static boolean inArea(MapPlacement placement, Area area){
		//TODO: should return whether there is an overlap between this and the specified area
		//IDEA: use .intersects(MapPlacement placement) method
		return false;
	}

	/**
	 * Checks whether two placements of circles intersect
	 * @param placement
	 * @param otherPlacement
	 * @return
	 */
	private static boolean intersectCircCirc(MapPlacement placement, MapPlacement otherPlacement) {
		return 
				Coordinate.getDistance(placement.getCoordinate(), otherPlacement.getCoordinate()) //distance between circle centers
				< 
				(((Circular) placement.getShape()).getRadius() + //radius this circle
						((Circular) otherPlacement.getShape()).getRadius()); //radius other circle
	}

	/**
	 * Checks whether two placements of lines intersect
	 * @param placement
	 * @param otherPlacement
	 * @return
	 */
	private static boolean intersectLineLine(MapPlacement placement, MapPlacement otherPlacement) {
		
		//begin line 1
		Coordinate p = 
				placement.getCoordinate().plus(
					((Line) placement.getShape()).getBegin()
				);
		//end line 1 minus begin line 1
		Coordinate r = 
				((Line) placement.getShape()).getEnd().minus(
					((Line) placement.getShape()).getBegin()
				);
		
		//begin line 2
		Coordinate q = 
				otherPlacement.getCoordinate().plus(
					((Line) otherPlacement.getShape()).getBegin()
				);
		//end line 2 minus begin line 2
		Coordinate s = 
				((Line) otherPlacement.getShape()).getEnd().minus(
					((Line) otherPlacement.getShape()).getBegin()
				);
		
		Coordinate qMinP = q.minus(p);
		
		
		//check if there is an intersection point
		double rCrossS = r.determinant(s);
		if(rCrossS == 0)
			return false;
		
		//get the intersection points as linear combination of the two lines
		double t = qMinP.determinant(s.divideBy(rCrossS));
		double u = qMinP.determinant(r.divideBy(rCrossS)); 
		
		//if the intersection points lies within the line segments return true
		if(t <= 1 && t >= 0 && u <= 1 && u >= 0)
			return true;
		
		return false;
	}

	/**
	 * Checks whether two placements of polygons intersect. WARNING: DOES NOT WORK FOR CONCENTRIC POLYGONS
	 * @param placement
	 * @param otherPlacement
	 * @return
	 */
	private static boolean intersectPolyPoly(MapPlacement placement, MapPlacement otherPlacement) {
		
		//TODO: implement checks for concentric polygons
		//loop over the lines in the polygons
		for(Line line1 : ((Polygonal) placement.shape).toLines())
			for(Line line2 : ((Polygonal) otherPlacement.shape).toLines()){
				//check if any of the lines intersect
				MapPlacement one = new MapPlacement(
						line1,
						placement.coordinate,
						placement.orientation);
				MapPlacement two = new MapPlacement(
						line2,
						otherPlacement.coordinate,
						otherPlacement.orientation);
				if(intersectLineLine(
						one, //MapPlacement one 
						two	//MapPlacement two
						)) 
					return true;
			}
		
		return false;
	}
	
	private static boolean intersectCircLine(
			MapPlacement circ, //circular
			MapPlacement line //line
			){
		
		//Get begin and end of the line relative to the centre of the circle
		Coordinate lineBegin = line.coordinate.plus(((Line) line.getShape()).getBegin()).minus(circ.coordinate);
		Coordinate lineEnd = line.coordinate.plus(((Line) line.getShape()).getEnd()).minus(circ.coordinate);
		
		Coordinate dif = lineEnd.minus(lineBegin);
		double dr = Coordinate.getDistance(lineBegin, lineEnd);
		double r = ((Circular) circ.getShape()).getRadius();
		
		//determinant
		double det = lineBegin.determinant(lineEnd);
		
		//discriminant
		double disc = r*r * 
				dif.getX()*dif.getX() - 
				det*det;
		
		if(disc < 0) 
			return false;
		
		//calculate intersection
		// coordinates relative of the circle centre
		double x = 
				(
					det * 
					dif.getY() - 
					sgn(dif.getY()) * 
					dif.getX() * 
					Math.sqrt(disc)
				) /
				(
					dr*dr
				);
		
		double y = 
				(
					-det * 
					dif.getX() - 
					Math.abs(dif.getY()) * 
					Math.sqrt(disc)
				) /
				(
					dr*dr
				);
		
		// lineBegin and lineEnd are relative to the centre of the circle, and so are the x and y of the coordinate.
		// if the intersection lies on the line segement there is an intersection. Otherwise the intersection lies outside
		// the line segment.
		if(new Line(lineBegin,lineEnd).liesOnLine(new Coordinate(x,y)))
			return true;
		
		x = 
				(
					det * 
					dif.getY() + 
					sgn(dif.getY()) * 
					dif.getX() * 
					Math.sqrt(disc)
				) /
				(
					dr*dr
				);
		
		y = 
				(
					-det * 
					dif.getX() + 
					Math.abs(dif.getY()) * 
					Math.sqrt(disc)
				) /
				(
					dr*dr
				);
		
		if(new Line(lineBegin,lineEnd).liesOnLine(new Coordinate(x,y)))
			return true;
		
		return false;
		
	}
	
	/**
	 * Alternative sgn function to the Math.sgn function. This Signum function does not return 0 when a = 0, but -1 instead.
	 * @param a double 
	 * @return -1 if a < 0 or 1 if a >= 0
	 */
	private static double sgn(double a){
		if (a < 0) return -1.0;
		return 1.0;
	}
	
	/**
	 * Checks whether a given circle and polygon intersect
	 * @param circ
	 * @param poly
	 * @return 
	 */
	private static boolean intersectCircPoly(MapPlacement circ, MapPlacement poly){
		for(Line line : ((Polygonal) poly.getShape()).toLines())
			if(intersectCircLine(circ,new MapPlacement(line,poly.getCoordinate(),poly.getOrientation())))
				return true;
		return false;
	}

	public double getWidth() {
		return this.shape.getWidth();
	}

	public double getHeight() {
		return this.shape.getHeight();
	}
}
