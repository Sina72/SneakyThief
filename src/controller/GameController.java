package controller;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import model.Map;
import model.mapElements.agents.Agent;
import model.mapElements.agents.Move;

/**
 * Controls the game actions / time flow
 * @author Stan
 *
 */
public class GameController extends Observable implements Observer {
	
	private double dt = 1;
	private Map map;
	
	public GameController(Map map){
		this.map = map;
	}
	
	public void timeStep(){
		Iterator<Agent> agentIt = map.agentIterator();
		while(agentIt.hasNext()){
			Agent a = agentIt.next();
			Move move = a.getMove();
		}
			
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
