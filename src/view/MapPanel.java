
package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
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

	
	public MapPanel()
	{
		MapDrawer drawer = new MapDrawer();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO update the map

	}
	
	public void paint(Graphics g, int x, int y)//x/y are end points of line
	{
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 50, 50);
	}
	
	public void drawShape(Shape newshape)
	{
		
	}
	public void drawShape(Rectangle shape, Graphics g)
	{
		int x = (int)shape.getX();
		int y = (int) shape.getY();
		int width = (int) shape.getWidth();
		int height = (int) shape.getHeight();
		g.drawLine(x,y,x+width,y);
		g.drawLine(x,y,x,y+height);
		g.drawLine(x+width,y,x+width,y+height);
		g.drawLine(x,y+height,x+width,y+height);
		
	}
}
