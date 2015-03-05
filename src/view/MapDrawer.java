package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import model.Map;
import model.geometry.Circular;
import model.geometry.Line;
import model.geometry.Polygonal;
import model.mapElements.MapPlacement;

public class MapDrawer extends JComponent {

	private Map map;

	private Color backcolor = Color.WHITE;
	private Color wallcolor = Color.black;
	private Color guardcolor = Color.blue;
	private Color intrudercolor = Color.red;

	// TODO: Add implementation for colour

	public MapDrawer(Map map) {
		this.map = map;
	}

	public void paintComponent(Graphics g) {

		Iterator<MapPlacement> placements = map.iterator();

		Graphics2D g2 = (Graphics2D) g;

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		while (placements.hasNext()) {
			MapPlacement currentplacement = placements.next();
			if (currentplacement.getShape() instanceof Circular) {
				double startx, starty, radius;
				startx = currentplacement.getCoordinate().getX();
				starty = currentplacement.getCoordinate().getX();
				radius = ((Circular) currentplacement.getShape()).getRadius();

				g2.draw(new Ellipse2D.Double(startx, starty, radius * 2,
						radius * 2));
			}
			if (currentplacement.getShape() instanceof Polygonal
					&& !(currentplacement.getShape() instanceof Line)) {

				List<Line> lines = ((Polygonal) currentplacement.getShape())
						.toLines();
				for (Line l : lines) {
					double startx, starty, endx, endy;
					startx = currentplacement.getCoordinate()
							.plus(l.getBegin()).getX();
					starty = currentplacement.getCoordinate()
							.plus(l.getBegin()).getY();
					endx = currentplacement.getCoordinate().plus(l.getEnd())
							.getX();
					endy = currentplacement.getCoordinate().plus(l.getEnd())
							.getY();

					g2.draw(new Line2D.Double(startx, starty, endx, endy));
				}
			}
			if (currentplacement.getShape() instanceof Line) {
				g2.draw(new Line2D.Double(new Point2D.Double(currentplacement
						.getCoordinate()
						.plus(((Line) currentplacement.getShape()).getBegin())
						.getX(), currentplacement.getCoordinate()
						.plus(((Line) currentplacement.getShape()).getBegin())
						.getY()), new Point2D.Double(currentplacement
						.getCoordinate()
						.plus(((Line) currentplacement.getShape()).getEnd())
						.getX(), currentplacement.getCoordinate()
						.plus(((Line) currentplacement.getShape()).getEnd())
						.getY())));
			}
		}

	}
}
