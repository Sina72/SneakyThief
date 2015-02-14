package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import model.Map;
import model.geometry.Coordinate;
import model.mapElements.agents.Agent;
import model.mapElements.agents.Move;
import model.mapElements.obstructions.Obstruction;

/**
 * Controls the game actions / time flow
 * 
 * @author Stan
 *
 */
public class GameController extends Observable {

	// default time step
	final private static double DEFAULT_DT = 1;

	Timer timer;

	private double dt;
	private Map map;

	private HashMap<Agent, Double> waiting;

	public GameController(Map map, double timeStepSize) {
		this.map = map;
		this.dt = timeStepSize; //in seconds
		waiting = new HashMap<Agent, Double>();
	}

	public GameController(Map map) {
		this(map, DEFAULT_DT);
	}
	
	public void setTimeStep(double dt){
		timer.cancel();
		this.dt = dt;
	}

	public void start() {
		schedule();
	}

	public void pauze() {
		timer.cancel();
	}

	public void schedule(){
		timer = new Timer();
		timer.scheduleAtFixedRate(
				new TimerTask(){
					public void run() {
						timeStep();
					}
				}, 
				1, 
				(long) (dt*1000));
	}

	public void timeStep() {
		moveAgents();
		informAgents();

		// call update of observers
		setChanged();
		notifyObservers();
	}

	private void informAgents() {
		Iterator<Agent> agentIt = map.agentIterator();
		while (agentIt.hasNext()) {
			Agent agent = agentIt.next();
			agent.inform(map.getAgentsInView(agent));
			agent.inform(map.getObstructionsInView(agent));
		}
	}

	private void moveAgents() {
		// iterate of all agents on the map
		Iterator<Agent> agentIt = map.agentIterator();
		while (agentIt.hasNext()) {
			Agent agent = agentIt.next();

			// calculate the move
			Move move = agent.getMove();
			Coordinate moveCoordinate = move.getDirectionCoordinate().times(
					move.getSpeed() * dt);

			// if obstruction met, store obstruction
			Obstruction o = map.move(agent, moveCoordinate);

			// if obstruction met
			if (o != null) {
				// if the agent was already waiting at the obstruction
				if (waiting.containsKey(agent)) {
					// decrement time left to wait
					waiting.replace(agent, waiting.get(agent) - dt);
					// if time left to wait runs out
					if (waiting.get(agent) < 0)
						// move the agent past the obstruction
						map.unobstructedMove(agent, moveCoordinate);
					// if the agent was not yet waiting
				} else {
					// calculate the needed waiting time
					Double waitingTime;
					if (o.getPermeability() == 0)
						waitingTime = Double.MAX_VALUE;
					else
						waitingTime = 1 / o.getPermeability() - 1;

					// put the agent in the waiting map
					waiting.put(agent, waitingTime);

				}
			} else {
				// if the agent is not trying to move through an obstruction,
				// but it is in the waiting map, remove it from the map
				if (waiting.containsKey(agent))
					waiting.remove(agent);
			}

		}
	}
}
