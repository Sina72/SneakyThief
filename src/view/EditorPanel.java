package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Panel for the map editor
 * 
 * @author Stan
 *
 */
public class EditorPanel extends JPanel 
{
	//THIS PANEL PLACED ON THE LEFT OF THE BORDER LAYOUT
	public EditorPanel()
	{
		//OUR MENU OPTIONS
		GridLayout mainlayout = new GridLayout(12,2);
		JLabel widthlabel = new JLabel("Width: ");
		JTextField widthinput = new JTextField("Must be >200");
		JLabel heightlabel = new JLabel("Height: ");
		JTextField heightinput = new JTextField("Must be >200");
		JLabel guardlabel = new JLabel("Guard number: ");	
		JTextField guardinput = new JTextField("1");
		JLabel thieflabel = new JLabel("Thief number: ");	
		JTextField thiefinput = new JTextField("1");
		JLabel sentrylabel = new JLabel("Sentry number: ");	
		JTextField sentryinput = new JTextField("1");
		JLabel goallabel = new JLabel("Amount of goal zones: ");	
		JTextField goalinput = new JTextField("1");
		JLabel guardmarkerlabel = new JLabel("Markers available to the guards.");	
		JLabel thiefmarkerlabel = new JLabel("Markers available to the thieves.");	
		JRadioButton guardmarker1 = new JRadioButton("Guard Marker 1");
		JRadioButton thiefmarker1 = new JRadioButton("Thief Marker 1");		
		JRadioButton guardmarker2 = new JRadioButton("Guard Marker 2");
		JRadioButton thiefmarker2 = new JRadioButton("Thief Marker 2");	
		JRadioButton guardmarker3 = new JRadioButton("Guard Marker 3");
		JRadioButton thiefmarker3 = new JRadioButton("Thief Marker 3");	
		JRadioButton guardmarker4 = new JRadioButton("Guard Marker 4");
		JRadioButton thiefmarker4 = new JRadioButton("Thief Marker 4");	
		JRadioButton guardmarker5 = new JRadioButton("Guard Marker 5");
		JRadioButton thiefmarker5 = new JRadioButton("Thief Marker 5");	
		
		//ADD OPTIONS IN THIS ORDER
		this.setLayout(mainlayout);
	 	this.add(widthlabel);
	 	this.add(widthinput);
	 	this.add(heightlabel);
    	this.add(heightinput);
      	this.add(guardlabel);
       	this.add(guardinput);
        this.add(thieflabel);
        this.add(thiefinput);
        this.add(sentrylabel);
        this.add(sentryinput);
      	this.add(goallabel);
      	this.add(goalinput);
      	this.add(guardmarkerlabel);
      	this.add(thiefmarkerlabel);
      	this.add(guardmarker1);
      	this.add(thiefmarker1);
      	this.add(guardmarker2);
      	this.add(thiefmarker2);
      	this.add(guardmarker3);
      	this.add(thiefmarker3);
      	this.add(guardmarker4);
      	this.add(thiefmarker4);
      	this.add(guardmarker5);
      	this.add(thiefmarker5); 
		 
		
	}

}
