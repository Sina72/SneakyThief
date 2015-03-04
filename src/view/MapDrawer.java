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
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		/*for(int i =0; i<placements.size;i++)
		 *{
		 *	currentplacement = placements.get(i);
		 *	g2.draw(currentplacement)
		 *}
		*/
	}

}
