package controller;

import model.Map;
import model.exceptions.MapPlacementNotFoundException;
import model.exceptions.OverlapException;
import model.geometry.Coordinate;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.geometry.Rectangular;
import model.mapElements.MapPlacement;
import model.mapElements.Obstruction;
import model.mapElements.agents.Guard;
import model.mapElements.agents.Intruder;
import model.mapElements.areas.Sentry;
import model.mapElements.areas.Shade;
import model.mapElements.areas.Target;

public class MapBuilder 
{
	//Permeability Constants
	private static final double DEFAULT_DOOR_PERMEABILITY = 0;
	private static final double DEFAULT_WALL_PERMEABILITY = 0;
	
	//Placement constants
	private static final double DEFAULT_ORIENTATION = 0;
	private static final Coordinate ZERO_COORDINATE = new Coordinate(0,0);
	private static final double DEFAULT_SHADE_DARKNESS = 0;
	
	private Map map;
	
	public MapBuilder(Map map){
		this.map = map;
	}
	
	public MapBuilder(int width, int height){
		this(new Map(width, height));
	}
	
	public void setSize(int width, int height){
		map.setSize(width,height);
	}
	
	private void addPlacement(MapPlacement placement) throws OverlapException{
		if(!map.checkOverlap(placement))
			map.addPlacement(placement);
		else
			throw new OverlapException();
	}
	
	public void addGuard(Coordinate coordinate) throws OverlapException{
		addPlacement(new Guard(coordinate));
	}
	
	public void addIntruder(Coordinate coordinate) throws OverlapException{
		addPlacement(new Intruder(coordinate));
	}
	
	public void addWall(Coordinate leftBottom, Coordinate rightTop) throws OverlapException{
		addPlacement(
				new Obstruction(
						new Rectangular(
								ZERO_COORDINATE, //shape translated to 0,0
								rightTop.minus(leftBottom)
								)
						,leftBottom // coordinate
						,DEFAULT_ORIENTATION
						,DEFAULT_WALL_PERMEABILITY) //orientation
				);
	}
	
	public void addDoor(Coordinate leftBottom, Coordinate rightTop) throws OverlapException{
		addPlacement(
				new Obstruction(
						new Line(
								ZERO_COORDINATE,
								rightTop.minus(leftBottom)
								)
						, leftBottom
						, DEFAULT_ORIENTATION
						, DEFAULT_DOOR_PERMEABILITY)
				);
	}
	
	public void addSentry(Coordinate coordinate) throws OverlapException{
		addPlacement(new Sentry(coordinate));
	}
	
	public void addShade(Coordinate... coordinates) throws OverlapException{
		Coordinate anchor = new Coordinate(coordinates[0].getX(), coordinates[0].getY());
		for(Coordinate c : coordinates)
			c = c.minus(anchor);
		
		addPlacement(
				new Shade(
						new Polygonal(coordinates),
						anchor,
						DEFAULT_ORIENTATION,
						DEFAULT_SHADE_DARKNESS
						)
				);
	}
	
	public void addTarget(Coordinate coordinate) throws OverlapException{
		addPlacement(new Target(coordinate));
	}
	
	public void remove(MapPlacement placement) throws MapPlacementNotFoundException{
		if(map.getPlacements().contains(placement))
			map.removeMapPlacement(placement);
		else
			throw new MapPlacementNotFoundException();
	}

}
