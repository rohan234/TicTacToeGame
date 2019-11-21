package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	
	static JFrame frame;
	//the draw window will handle drawing the object
	public static DrawWindow drawPanel;
	//height of the window
	public static int windowWidth = 600;
	static int windowHeight = 625;
	public static void main(String[] args) {
		System.out.println("Welcome to 2048");
		
		new Game().prepareGui();
		//end of mainDriver method 
	}
	
	
	public static void prepareGui() {
		//initialize the JFrame
		frame = new JFrame("2048");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new DrawWindow();
		
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		frame.setResizable(false);
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		
		frame.setSize(windowWidth, windowHeight);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		update();
		
	}
	public static void update() {
		try
		{
			Thread.sleep(30);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		frame.repaint();
		update();
	}
	
	
}
