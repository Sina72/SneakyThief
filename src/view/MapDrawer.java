package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		
		/*for(int i =0; i<placements.size;i++)
		 *{
		 *	currentplacement = placements.get(i);
		 *	if(currentplacement is certain shape)
		 *	{
		 *		do a draw method
		 *	}
		 *	if(currentplacement is a polygon)
		 *	{
		 *		for(each coordinate)
		 *		{
		 *			draw line to previous coordinate
		 *		}
		 *	}
		 *	if(currentplacement is a line)
		 *	{
		 *		g2.draw(new Line2D.Double(firstcoordinate, secondcoordinate)
		 *	}
		 *}
		*/
		
		
		
	}

}
