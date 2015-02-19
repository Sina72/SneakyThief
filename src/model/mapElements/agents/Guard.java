package model.mapElements.agents;

import model.geometry.Circular;
import model.geometry.Coordinate;

/**
 * The guard agents.
 * 
 * @author Stan
 *
 */
public class Guard extends Agent {

	public Guard(Coordinate coordinate){
		super(coordinate);
		//TODO: setConstants(????)
	}
	
	public Guard(Circular shape, Coordinate coordinate, double orientation) {
		super(shape,coordinate, orientation);
	}
	
	public void enterSentry(){
		//TODO: implement enterSentry
		//something happening to vision range etc. need to read defaults from settings.xml?
	}
	
	public void leaveSentry(){
		//TODO: implement leaveSentry()
	}

}
