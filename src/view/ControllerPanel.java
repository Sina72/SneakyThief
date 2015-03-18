package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GameController;

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

class StartListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent event) {
		//TODO: GIVE ALL INFORMATION FROM EDITOR PANEL TO MAP
		//TODO: BUILD MAP
		//TODO: RUN THE GAME
		
	}

	//DONT NEED THESE
	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}

class PauseListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
