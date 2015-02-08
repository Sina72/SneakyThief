package model.geometry;


public class Line extends Polygonal {
	
	private static final double EPSILON = 0.001;
	private Coordinate begin, end;
	
	public Line (Coordinate begin, Coordinate end){
		super(new Coordinate[] { begin, end});
		this.begin = begin;
		this.end = end;
	}
	
	public Line (Coordinate end){
		this(new Coordinate(0,0), end);
	}

	@Override
	double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double getSlope(){
		Coordinate dif = end.minus(begin);
		return dif.getY() / dif.getX();
	}
	
	public double getIntercept(){
		return begin.getY() - getSlope() * begin.getX();
	}
	
	public boolean liesOnLine(Coordinate c){
		double a = getSlope();
		double b = getIntercept();
		if(
				Math.abs( c.getX() * a + b - c.getY() ) < EPSILON && //coordinate is on span of line
				c.getX() >= begin.getX() && c.getX() <= end.getX() && //coordinate is in x-range
				c.getY() >= begin.getY() && c.getY() <= end.getY()) //coordinate is in y-range (is this check necessary?)
			return true;
		return false;
	}

	/**
	 * @return the begin
	 */
	public Coordinate getBegin() {
		return begin;
	}

	/**
	 * @return the end
	 */
	public Coordinate getEnd() {
		return end;
	}

}
