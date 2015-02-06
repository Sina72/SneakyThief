package model;

public class MapPlacement<E extends MapElement> {
	private E element;
	private MapCoordinate coordinate;
	
	public MapPlacement(E element, MapCoordinate coordinate){
		this.element = element;
		this.coordinate = coordinate;
	}

	public MapCoordinate getMapCoordinate() {
		return coordinate;
	}
	
	public E getMapElement(){
		return element;
	}
}
