package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.GameController;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		initFrame();
	}

	private void initFrame() {
		//TODO: Color legend
		this.setLayout(new BorderLayout());
		setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		EditorPanel editorpanel = new EditorPanel();
		ControllerPanel controllerpanel = new ControllerPanel();
		this.add(editorpanel, BorderLayout.WEST);
		this.add(controllerpanel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	public void connectGameController(GameController controller){
		MapPanel mapPanel = new MapPanel(controller.getMap());
		controller.addObserver(mapPanel);
		this.add(mapPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Get the input values from the editor panel
	 * @param panel
	 * @return ArrayList with inputs
	 */
	public ArrayList<Integer> giveValues(EditorPanel panel)
	{
		return panel.getValues();
	}
}
