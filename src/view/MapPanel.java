package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Map;
import model.geometry.Circular;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.mapElements.MapPlacement;

/**
 * Draws a map on a JPanel
 */
public class MapPanel extends JPanel implements Observer {

	// THIS PANEL PLACED ON THE RIGHT OF THE BORDER LAYOUT
	private Map map;

	private final static double PX_PER_M = 3779.527559055;

	private static double scale = 1 / 1000.0;

	public MapPanel(Map map) {
		// TODO: Make scale dependent on screen size, i.e. make map grow with
		// screen size
		// scale = Math.max(map.getMapWidth(),map.getMapHeight()) /
		// Math.min(super.getWidth(), super.getHeight());
		this.map = map;
		this.setSize(getMaximumSize());
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
	}

	/**
	 * Scales from meters to pixels
	 * 
	 * @return
	 */
	private static double scale(double meters) {
		return meters * PX_PER_M * scale;
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public void paint(Graphics g, int x, int y)// x/y are end points of line
	{
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 50, 50);
	}

	public void drawShape(Shape newshape) {

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Iterator<MapPlacement> placements = map.iterator();

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		while (placements.hasNext()) {
			MapPlacement currentplacement = placements.next();

			// Shape is circular
			if (currentplacement.getShape() instanceof Circular) {
				double startx, starty, radius;
				startx = scale(currentplacement.getCoordinate().getX());
				starty = scale(currentplacement.getCoordinate().getX());
				radius = scale(((Circular) currentplacement.getShape())
						.getRadius());

				g2.draw(new Ellipse2D.Double(startx, starty, radius * 2,
						radius * 2));
			}

			// Shape is Polygonal
			if (currentplacement.getShape() instanceof Polygonal) {

				List<Line> lines = ((Polygonal) currentplacement.getShape())
						.toLines();
				for (Line l : lines) {
					double startx, starty, endx, endy;
					startx = scale(currentplacement.getCoordinate()
							.plus(l.getBegin()).getX());
					starty = scale(currentplacement.getCoordinate()
							.plus(l.getBegin()).getY());
					endx = scale(currentplacement.getCoordinate()
							.plus(l.getEnd()).getX());
					endy = scale(currentplacement.getCoordinate()
							.plus(l.getEnd()).getY());
					
					//TODO: Rotation
					g2.draw(new Line2D.Double(startx, starty, endx, endy));
				}
			}
		}

	}
	

	public void drawShape(Rectangle shape, Graphics g) {
		int x = (int) shape.getX();
		int y = (int) shape.getY();
		int width = (int) shape.getWidth();
		int height = (int) shape.getHeight();
		g.drawLine(x, y, x + width, y);
		g.drawLine(x, y, x, y + height);
		g.drawLine(x + width, y, x + width, y + height);
		g.drawLine(x, y + height, x + width, y + height);

	}
}
