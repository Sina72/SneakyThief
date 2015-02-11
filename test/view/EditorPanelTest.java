package view;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EditorPanelTest {
	
	public static void main(String[] args){
		test();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public static void test() {
		JFrame frame = new JFrame();
		frame.setSize(500, 300);
		
		EditorPanel ep = new EditorPanel();
		frame.add(ep);
		
		frame.setVisible(true);
	}

}
