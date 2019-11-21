package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawWindow extends JPanel {
	/**
	 * 
	 */

	public void paintComponent(Graphics g) {
		//fill black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//first vertical
		g.setColor(Color.blue);
		g.fillRect(200, 0, 4, this.getHeight());
		
		//second vertical
		g.setColor(Color.blue);
		g.fillRect(400, 0, 4, this.getHeight());
		
		//1st horizontal
		g.setColor(Color.blue);
		g.fillRect(0, 200, this.getWidth(), 4);
		
		//2nd horizontal
		g.setColor(Color.blue);
		g.fillRect(0, 400, this.getWidth(),4);
		
		
		for(int row = 0; row<3; row ++) { 
			for(int col = 0; col<3; col++) {
				//draw g makes the graphics object work 
				Game.board[row][col].draw(g);
			}
		}
		
		
	
		
	}
	
	
	
}