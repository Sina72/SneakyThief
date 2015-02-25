
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Map;

/**
 * Draws a map on a JPanel
 */
public class MapPanel extends JPanel implements Observer {
	
	//THIS PANEL PLACED ON THE RIGHT OF THE BORDER LAYOUT
	private Map map;
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO update the map

	}
	
	public void draw()
	{
		/*for each MapPlacement we must draw it, essentially drawing the map
		 * get map
		 * get placements
		 * draw placements
		*/
	
	}
	
	public void drawShape(Shape newshape)
	{
		
	}
}
