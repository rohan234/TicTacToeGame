//Project: Game_2048
//File: DrawWindow

package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8242558423155622593L;

	public void paintComponent(Graphics g) {
		//fill black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.blue);
		g.fillRect(500, 0, 440, this.getHeight());
	
		
	}
	
	
	
}
