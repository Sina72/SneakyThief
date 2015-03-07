package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.GameController;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		initFrame();
	}

	private void initFrame() {
		
		this.setLayout(new BorderLayout());
		setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(new EditorPanel(), BorderLayout.WEST);
		this.add(new ControllerPanel(), BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	public void connectGameController(GameController controller){
		MapPanel mapPanel = new MapPanel(controller.getMap());
		controller.addObserver(mapPanel);
		this.add(mapPanel, BorderLayout.CENTER);
	}
	
}
