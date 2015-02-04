package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Map;

/**
 * Draws a map on a JPanel
 * 
 * @author Stan
 *
 */
public class MapPanel extends JPanel implements Observer {
	private Map map;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
