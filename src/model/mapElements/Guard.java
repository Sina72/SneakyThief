package model.mapElements;

import model.geometry.Circular;
import model.geometry.Coordinate;

/**
 * The guard agents.
 * 
 * @author Stan
 *
 */
public class Guard extends Agent {

	public Guard(){
		super();
		//TODO: setConstants(????)
	}
	
	public Guard(Circular shape, Coordinate coordinate, double orientation) {
		super(shape,coordinate, orientation);
	}
	
	public void enterSentry(){
		//TODO: implement
		//something happening to vision range etc. need to read defaults from settings.xml?
	}

}