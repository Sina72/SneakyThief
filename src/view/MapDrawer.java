package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;

import javax.swing.JComponent;

public class MapDrawer extends JComponent
{
	private Color backcolor = Color.WHITE;
	private Color wallcolor = Color.black;
	private Color guardcolor = Color.blue;
	private Color intrudercolor = Color.red;
	// TODO: Add implementation for colour
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//TODO: Get the map and the placements
		//TODO: Finish draw methods
		for(int i =0; i<placements.size;i++)
		{
		 	currentplacement = placements.get(i);
		 	if(currentplacement is certain shape)
		 	{
		 		do a certain draw method
		 	}
		 	if(currentplacement instanceof Polygon && !currentplacement instanceof Line)
		 	{
		 		new List<> listofpoints = currentplacement.toLines();
		 		for(int i =0;i>listofpoints.size;i++)
		 		{
					Double startx,starty,endx,endy;
	 				startx = listofpoints[i].getX();
		 			starty = listofpoints[i].getY();
		 			if(i == listofpoints.size)
		 			{
		 				endx = listofpoints[i+1].getX();
						endy = listofpoints[i+1].getY();
	 				}
		 			else
		 			{	
		 				endx = listofpoints[0].getX();
	 					endy = listofpoints[0].getY();
	 				}
		 				
					g2.draw(new Line2D.Double(startx,starty,endx,endy));
	 			}
		 	}
		 	if(currentplacement instanceof Line)
		 	{
		 		g2.draw(new Line2D.Double(firstcoordinate, secondcoordinate)
		 	}
		}
		
		
		
		
	}

}
