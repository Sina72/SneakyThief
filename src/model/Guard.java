package model;

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
	
	public Guard(Shape shape, double orientation) {
		super(shape, orientation);
	}
	
	public void enterSentry(){
		//TODO: implement
		//something happening to vision range etc. need to read defaults from settings.xml?
	}

}
