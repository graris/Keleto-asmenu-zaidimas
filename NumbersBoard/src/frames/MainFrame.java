package frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import main.Main;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kortelës");
		setSize(1000, 400);	
		setResizable(false);
		
		init();
	}
	
	/**
	 * inits main JFrame which holds layout
	 */
	private void init() {
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(1, 1, 0, 0));
		
		Main m = new Main();
		
		add(m);
		
		setVisible(true);
	}

}
