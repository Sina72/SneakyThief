package model.mapElements.Agents;

import model.geometry.Circular;
import model.geometry.Coordinate;

/**
 * Intruder agent
 * 
 * @author Stan
 *
 */
public class Intruder extends Agent {

	public Intruder(Coordinate coordinate){
		super( coordinate );
		//TODO: setConstants(???) with sprint
	}
	
	public Intruder(Circular shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
		// TODO Auto-generated constructor stub
	}

}
