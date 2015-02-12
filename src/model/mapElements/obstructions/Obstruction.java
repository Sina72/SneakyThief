package model.mapElements.obstructions;

import model.geometry.Coordinate;
import model.geometry.Shape;
import model.mapElements.MapPlacement;

/**
 * Common structure for all obstructions
 * @author Stan
 *
 */
public class Obstruction extends MapPlacement {

	ObstructionType type;
	//0 is completely impermeable, 1 is completely permeable
	double permeability;
	
	public Obstruction(Shape shape, Coordinate coordinate, double orientation, double permeability) {
		super(shape, coordinate, orientation);
		this.permeability = permeability;
	}
	
	public Obstruction(Shape shape, Coordinate coordinate, double orientation){
		this(shape, coordinate, orientation, 0);
	}

	public void setType(ObstructionType type){
		this.type = type;
	}
	
	public ObstructionType getType(){
		return type;
	}
	
	public double getPermeability(){
		return permeability;
	}
	
	public void setPermeability(double newPermeability){
		if(newPermeability <= 1 && newPermeability >= 0)
			this.permeability = newPermeability;
	}
	

}
