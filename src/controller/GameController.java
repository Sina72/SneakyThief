package controller;

import java.util.Observable;
import java.util.Observer;

/**
 * Controls the game actions / time flow
 * @author Stan
 *
 */
public class GameController extends Observable implements Observer {
	
	private final double dt = 1;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
