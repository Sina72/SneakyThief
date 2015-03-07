package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Map;

public class MainFrame extends JFrame {
	
	private Map map;
	
	public MainFrame(Map map){
		this.map = map;
		
		initFrame();
	}

	private void initFrame() {
		setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new MapPanel(map));
		this.setVisible(true);
	}
	
}
