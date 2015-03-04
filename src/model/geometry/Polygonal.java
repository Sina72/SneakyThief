package model.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygonal extends Shape {
	
	// points should be in counterclockwise order
	private List<Coordinate> points;
	
	public Polygonal(Coordinate... points){
		this.points = new ArrayList<Coordinate>();
		for(Coordinate point : points)
			this.points.add(point);
			
	}
	
	public Polygonal(List<Coordinate> points){
		this.points = points;
	}
	
	public List<Coordinate> getCoordinates(){
		return points;
	}
	
	/**
	 * 
	 * @return List<Line> of line representation of the polygon
	 */
	public List<Line> toLines(){
		ArrayList<Line> lines = new ArrayList<Line>();
		
		for(int i = 0; i < points.size()-1; i ++)
			lines.add(new Line(points.get(i),points.get(i+1)));
		
		lines.add(new Line(points.get(points.size()-1),points.get(0)));
		
		return lines;
		
	}

	@Override
	public double getWidth() {
		double maxX = points.get(0).getX();
		double minX = points.get(0).getX();
		for(Coordinate point : points){
			if(point.getX() > maxX)
				maxX = point.getX();
			if(point.getX() < minX)
				minX = point.getX();
		}
			
		return maxX-minX;
	}

	@Override
	public double getHeight() {
		double maxY = points.get(0).getY();
		double minY = points.get(0).getY();
		for(Coordinate point : points){
			if(point.getY() > maxY)
				maxY = point.getY();
			if(point.getY() < minY)
				minY = point.getY();
		}
			
		return maxY - minY;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Polygonal){
			for(Coordinate c : points)
				if(!((Polygonal) obj).points.contains(c))
					return false;
			return true;
		}else{
			return false;
		}
		
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
