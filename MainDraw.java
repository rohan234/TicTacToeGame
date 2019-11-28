
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MainDraw extends JComponent {

    public int xPos = 50;
    public int yPos = 50;
    
    public int width = 200;
    public int height = 200;
    
    final int TEXT_PADDING = 15;
    
    Color highlight = new Color(255, 255, 0, 127);
    
    void paintText (Graphics g) {
    	g.drawString("Movement Keys", 600 + TEXT_PADDING, 20);
        
		g.drawString("Q: Up and Left", 600 + TEXT_PADDING, 40);
		g.drawString("W: Up", 600 + TEXT_PADDING, 60);
		g.drawString("E: Up and Right", 600 + TEXT_PADDING, 80);
		g.drawString("A: Left", 600 + TEXT_PADDING, 100);
		g.drawString("S: Sit", 600 + TEXT_PADDING, 120);
		g.drawString("D: Right", 600 + TEXT_PADDING, 140);
		g.drawString("Z: Down and Left", 600 + TEXT_PADDING, 160);
		g.drawString("X: Down", 600 + TEXT_PADDING, 180);
		g.drawString("C: Down and Right", 600 + TEXT_PADDING, 200);
		g.drawString("J: Jump", 600 + TEXT_PADDING, 220);
		g.drawString("ENTER: restart game", 600 + TEXT_PADDING, 240);
		g.drawString("Objective: Try not to get eaten by the Mhos. Use strategic ", 600 + TEXT_PADDING, 280);
		g.drawString(" movements to get the mhos to run into fences. Good Luck!", 600 + TEXT_PADDING, 300);
    }
    
    void paintBoard(Graphics g, String[][] board) {
    	int xPaint;
        int yPaint;
        
        for (int y = 0; y < 3; y++) {
        	for (int x = 0; x < 3; x++) {
        		
        		xPaint = width * x;
        		yPaint = height * y;
        		
        		
        		if (board[y][x] == "X") { //IF the marker is a fence
        			g.setColor(Color.orange);
        			g.fillRect(xPaint,  yPaint,  width, height);
        		} 
        		else if (board[y][x] == "O") { //If the marker is the player
        			g.setColor(Color.black);
        			g.fillOval(xPaint,  yPaint,  width, height);
        			
        			g.setColor(Color.white);
        			g.fillOval(xPaint + 25,  yPaint + 25,  width / 4 * 3, height / 4 * 3);
        		} 
        		else if (board[y][x] == "-") { //If the marker is an empty space
        			g.setColor(Color.black);
        			g.drawRect(xPaint,  yPaint,  width, height);
        		}
        		if (board[y][x] == "+") {
        			g.setColor(highlight);
        			g.fillRect(xPaint, yPaint, width, height);
        		}
        		
        	}
        }
    }
    
    void paintGameBoard(Graphics g) {
    	paintBoard(g, Board.gameBoard);
    }
    
    void paintHLBoard(Graphics g) {
    	paintBoard(g, Board.hlBoard);
    }

    public void paintComponent(Graphics g) {
        
    	super.paintComponent(g);
        
    	paintGameBoard(g);
        
        paintHLBoard(g);
        
        paintText(g);
        
    }

}



