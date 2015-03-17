package view;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import model.Map;
import model.geometry.Coordinate;
import model.geometry.Polygonal;
import model.geometry.Rectangular;
import model.mapElements.Obstruction;
import model.mapElements.agents.Guard;

import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerPanelTest {

	public static void main(String[] args)
	{
		BorderLayout layout = new BorderLayout();
		JFrame frame = new JFrame();
		frame.setSize(200,200);
		frame.setVisible(true);
		frame.setLayout(layout);
		frame.add(new ControllerPanel());
		frame.add(new EditorPanel());
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
