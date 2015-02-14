package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Map;

/**
 * Draws a map on a JPanel
 * 
 * @author Stan
 *
 *
 *
 *
 */
public class MapPanel extends JPanel implements Observer {
	private Map map;
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO update the map

	}
}
