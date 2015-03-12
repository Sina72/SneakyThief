package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Map;
import model.geometry.Circular;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.mapElements.MapPlacement;
import model.mapElements.Obstruction;
import model.mapElements.agents.Guard;
import model.mapElements.agents.Intruder;
import model.mapElements.areas.Area;

/**
 * Draws a map on a JPanel
 */
public class MapPanel extends JPanel implements Observer {

	// THIS PANEL PLACED ON THE RIGHT OF THE BORDER LAYOUT
	private Map map;

	private final static double PX_PER_M = 3779.527559055;

	private static double scale = 1 / 10000.0;

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
	private double scale(double meters) {
		double widthPanel = this.getWidth();
		double heightPanel = this.getHeight();
		double scaleHeight = widthPanel/map.getMapHeight();
		double scaleWidth = heightPanel/map.getMapWidth();
		this.scale = Math.min(scaleHeight, scaleWidth)/4000;
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

	public void drawPlacement(MapPlacement placement, Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		//Color coding
		if(placement instanceof Guard)
			g2.setColor(Color.CYAN);
		else if(placement instanceof Obstruction)
			g2.setColor(Color.WHITE);
		else if(placement instanceof Intruder)
			g2.setColor(Color.RED);
		else if(placement instanceof Area)
			g2.setColor(Color.DARK_GRAY);
		else
			g2.setColor(Color.GRAY); //Default color
		
		// Shape is circular
		//?Scale works from meters to pixels, does this work then?
		if (placement.getShape() instanceof Circular) {
			double startx, starty, radius;
			startx = scale(placement.getCoordinate().getX());
			starty = scale(placement.getCoordinate().getY());
			radius = scale(((Circular) placement.getShape())
					.getRadius());

			g2.draw(new Ellipse2D.Double(startx, starty, radius * 2,
					radius * 2));
		}

		// Shape is Polygonal
		if (placement.getShape() instanceof Polygonal) {

			List<Line> lines = ((Polygonal) placement.getShape())
					.toLines();
			for (Line l : lines) {
				double startx, starty, endx, endy;
				startx = scale(placement.getCoordinate()
						.plus(l.getBegin()).getX());
				starty = scale(placement.getCoordinate()
						.plus(l.getBegin()).getY());
				endx = scale(placement.getCoordinate()
						.plus(l.getEnd()).getX());
				endy = scale(placement.getCoordinate()
						.plus(l.getEnd()).getY());
				
				//TODO: Rotation implementation (from currentplacement.getOrientation())
				g2.draw(new Line2D.Double(startx, starty, endx, endy));
			}
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		for(MapPlacement placement : map.getPlacements()){
			drawPlacement(placement, g);
		}

	}
}
