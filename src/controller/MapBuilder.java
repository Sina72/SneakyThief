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
	
	//TODO: premade default maps (sharon?)
	
	//Permeability Constants
	private static final double DEFAULT_DOOR_PERMEABILITY = 0;
	private static final double DEFAULT_WALL_PERMEABILITY = 0;
	
	//Placement constants
	private static final double DEFAULT_ORIENTATION = 0;
	private static final Coordinate ZERO_COORDINATE = new Coordinate(0,0);
	private static final double DEFAULT_SHADE_DARKNESS = 0;
	
	private Map map;
	
	
	/**
	 * Constructor to build a map from a previously built map
	 * @param map
	 */
	public MapBuilder(Map map){
		this.map = map;
	}
	
	/**
	 * Constructor to build a new map with a specific size
	 * @param width Width of the new Map
	 * @param height Height of the new Map
	 */
	public MapBuilder(int width, int height){
		this(new Map(width, height));
	}
	
	/**
	 * Returns the built map
	 * @return the built map
	 */
	public Map getMap(){
		return map;
	}
	
	/**
	 * 
	 * Reset the size of the map
	 * @param width New width of the map
	 * @param height new height of the map
	 */
	public void setSize(int width, int height){
		map.setSize(width,height);
	}
	
	/**
	 * General method that puts any placement on the map, with checking for overlap
	 * @param placement
	 * @throws OverlapException Element that is tried to be placed cannot be placed because of overlap
	 */
	private void addPlacement(MapPlacement placement) throws OverlapException{
		if(!map.checkOverlap(placement))
			map.addPlacement(placement);
		else
			throw new OverlapException();
	}
	
	/**
	 * Adds a default guard at the specified coordinate
	 * @param coordinate coordinate for the guard
	 * @throws OverlapException
	 */
	public void addGuard(Coordinate coordinate) throws OverlapException{
		addPlacement(new Guard(coordinate));
	}
	
	/**
	 * Adds a default intruder at the specified coordinate
	 * @param coordinate
	 * @throws OverlapException
	 */
	public void addIntruder(Coordinate coordinate) throws OverlapException{
		addPlacement(new Intruder(coordinate));
	}
	
	/**
	 * Adds a default wall with the specified dimensions
	 * @param leftBottom
	 * @param rightTop
	 * @throws OverlapException
	 */
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
	
	/**
	 * Adds a default door (line obstruction with permeability) to the map
	 * @param leftBottom
	 * @param rightTop
	 * @throws OverlapException
	 */
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
	
	/**
	 * Adds a default sentry to the map
	 * @param coordinate
	 * @throws OverlapException
	 */
	public void addSentry(Coordinate coordinate) throws OverlapException{
		addPlacement(new Sentry(coordinate));
	}
	
	/**
	 * Adds a shade to the map with the specified coordinates
	 * @param coordinates
	 * @throws OverlapException
	 */
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
	
	/**
	 * Adds a target for the intruder to the map
	 * @param coordinate
	 * @throws OverlapException
	 */
	public void addTarget(Coordinate coordinate) throws OverlapException{
		addPlacement(new Target(coordinate));
	}
	
	/**
	 * Removes a placement on the map, if it exists on the map, otherwise throws exception
	 * @param placement
	 * @throws MapPlacementNotFoundException The MapPlacement is not on the map.
	 */
	public void remove(MapPlacement placement) throws MapPlacementNotFoundException{
		if(map.getPlacements().contains(placement))
			map.removeMapPlacement(placement);
		else
			throw new MapPlacementNotFoundException();
	}

}
