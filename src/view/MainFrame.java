package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Map;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		initFrame();
	}

	private void initFrame() {
		setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
