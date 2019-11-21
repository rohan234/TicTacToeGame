package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	
	static JFrame frame;
	//the draw window will handle drawing the object
	public static DrawWindow drawPanel;
	//height of the window
	public static int windowWidth = 600;
	static int windowHeight = 625;
	
	
	public static Square[][] board = new Square[3][3];
	
	public static void main(String[] args) {
		System.out.println("Welcome to tictactoe");
		//prep the game
		prepSquare();
		new Game().prepareGui();
		//end of mainDriver method 
	}
	
	public static void prepSquare() {
		for(int row = 0; row<3; row ++) { 
			for(int col = 0; col<3; col++) {
				//build a sqaure
				Square sq = new Square(row,col);
				//put the square in the array of squares
				board[row][col] = sq;
			}
		}
	}
	
	//make window
	public static void prepareGui() {
		//initialize the JFrame
		frame = new JFrame("tictactoe");
		//close when you press x
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new DrawWindow();
		//add content
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		//make it resizeable
		frame.setResizable(false);
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		
		frame.setSize(windowWidth, windowHeight);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		update();
		
	}
	//triggers repaint and how fast to move stuff
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