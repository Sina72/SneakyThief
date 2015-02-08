package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel with user controls
 * 
 * @author Stan
 *
 */
public class ControllerPanel extends JPanel {

	public ControllerPanel()
	{
		//CREATE ELEMENTS
		GridLayout controllerlayout = new GridLayout(3,1);
		JButton startgame = new JButton("Begin Simulation");
		JButton pausegame = new JButton("Pause Simulation");
		JButton stopgame = new JButton("Stop Simulation");
		
		//ADD ELEMENTS
		this.setLayout(controllerlayout);
		this.add(startgame);
		this.add(pausegame);
		this.add(stopgame);
	}
}
