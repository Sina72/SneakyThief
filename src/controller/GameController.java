package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.Map;
import model.geometry.Coordinate;
import model.geometry.Polygonal;
import model.geometry.Rectangular;
import model.mapElements.Obstruction;
import model.mapElements.agents.Agent;
import model.mapElements.agents.Guard;
import model.mapElements.agents.Move;
import view.MainFrame;
import view.MapPanel;

/**
 * Controls the game actions / time flow
 * 
 * @author Stan
 *
 */
public class GameController extends Observable {
	private boolean m_debug = false;
	
	public static void main(String[] args){
		
		Map map = DefaultMaps.standardMap();
		
		
		//TODO: Problem: Agents sometimes jump big steps.
		//TODO: Problem?: Agents do not collide with each other (this might be desirable?)
		//TODO: Problem: agents don't stop at objects
		
		for(int i = 0; i < 20; i++){
			Guard guard = new Guard(new Coordinate(
					new Random().nextInt((int)map.getMapWidth()),
					new Random().nextInt((int)map.getMapHeight())));
			guard.LoadSettingsXML("./settings/settings.xml");
			map.addPlacement(guard);
		}
		
		
		/*Guard guard = new Guard(new Coordinate(100,100));
		guard.LoadSettingsXML("./settings/settings.xml");
		map.addPlacement(guard);
		Guard guard2 = new Guard(new Coordinate(50,50));
		guard2.LoadSettingsXML("./settings/settings.xml");
		map.addPlacement(guard2);
		*/
		GameController controller = new GameController(map, 1);
		
		MainFrame frame = new MainFrame();
		
		frame.connectGameController(controller);
		
		controller.start();
		
	}
	

	// default time step
	final private static double DEFAULT_DT = 1;

	private static final double DELAY = 10;

	Timer timer;

	private double dt;
	private Map map;
	
	public Map getMap(){
		return map;
	}

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
				(long) (dt*DELAY));
	}

	public void timeStep() {
		//System.out.println("Timestep");
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
			//rotate the agent (always allowed as agents are circular)
			map.rotate(agent, move.getRotationSpeed()*dt);

			// if obstruction met
			if (o != null) {
				if (m_debug) System.out.println("Agent " + agent + " met an obstruction");
				// if the agent was already waiting at the obstruction
				if (waiting.containsKey(agent)) {
					// decrement time left to wait
					
					//TODO : FIX REPLACE!! 
					//waiting.replace(agent, waiting.get(agent) - dt);
					
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
