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
	public EditorPanel()
	{
		//OUR MENU OPTIONS
		GridLayout mainlayout = new GridLayout(12,2);
		JLabel widthlabel = new JLabel("Width: ");
		JTextField widthinput = new JTextField("Must be >200");
		JLabel heightlabel = new JLabel("Height: ");
		JTextField heightinput = new JTextField("Must be >200");
		JLabel guardlabel = new JLabel("Guard number: ");	
		JTextField guardinput = new JTextField();
		JLabel thieflabel = new JLabel("Thief number: ");	
		JTextField thiefinput = new JTextField("1");
		JLabel sentrylabel = new JLabel("Sentry number: ");	
		JTextField sentryinput = new JTextField();
		JLabel goallabel = new JLabel("Amount of goal zones: ");	
		JTextField goalinput = new JTextField();
		JLabel guardmarkerlabel = new JLabel("Choose the markers available to the guards.");	
		JLabel thiefmarkerlabel = new JLabel("Choose the markers available to the thieves.");	
		JRadioButton guardmarker1 = new JRadioButton();
		JRadioButton thiefmarker1 = new JRadioButton();		
		JRadioButton guardmarker2 = new JRadioButton();
		JRadioButton thiefmarker2 = new JRadioButton();	
		JRadioButton guardmarker3 = new JRadioButton();
		JRadioButton thiefmarker3 = new JRadioButton();	
		JRadioButton guardmarker4 = new JRadioButton();
		JRadioButton thiefmarker4 = new JRadioButton();	
		JRadioButton guardmarker5 = new JRadioButton();
		JRadioButton thiefmarker5 = new JRadioButton();	
		
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
