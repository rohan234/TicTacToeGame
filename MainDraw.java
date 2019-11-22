
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MainDraw extends JComponent {

    public int xPos = 50;
    public int yPos = 50;
    
    public int width = 50;
    public int height = 50;
    
    public int textPadding = 15;
    
    public boolean isGameOver = false;
    public boolean didPlayerWin = false;

    public void paintComponent(Graphics g) {
        
    	super.paintComponent(g);
        
        int xPaint;
        int yPaint;
        
        
        g.drawString("Movement Keys", 600 + textPadding, 20);
        
		g.drawString("Q: Up and Left", 600 + textPadding, 40);
		g.drawString("W: Up", 600 + textPadding, 60);
		g.drawString("E: Up and Right", 600 + textPadding, 80);
		g.drawString("A: Left", 600 + textPadding, 100);
		g.drawString("S: Sit", 600 + textPadding, 120);
		g.drawString("D: Right", 600 + textPadding, 140);
		g.drawString("Z: Down and Left", 600 + textPadding, 160);
		g.drawString("X: Down", 600 + textPadding, 180);
		g.drawString("C: Down and Right", 600 + textPadding, 200);
		g.drawString("J: Jump", 600 + textPadding, 220);
		g.drawString("ENTER: restart game", 600 + textPadding, 240);
		g.drawString("Objective: Try not to get eaten by the Mhos. Use strategic ", 600 + textPadding, 280);
		g.drawString(" movements to get the mhos to run into fences. Good Luck!", 600 + textPadding, 300);


		
		//if the game is over and the player won print ... else print ... reset the booleans
        if(isGameOver) {
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 0, 600, 600);
        	g.setColor(Color.WHITE);
        	g.drawString(didPlayerWin ? "YOU WON!!!" : "You lost...you are bad: Press enter to restart!", 280, 293);
        	isGameOver = false;
        	didPlayerWin = false;
        	return;
        }
        
        for (int x = 0; x < 12; x++) {
        	for (int y = 0; y < 12; y++) {
        		
        		xPaint = 50 * x;
        		yPaint = 50 * y;
        		
        		if (Board.board[y][x] == "#") { //IF the marker is a fence
        			g.setColor(Color.orange);
        			g.fillRect(xPaint,  yPaint,  width, height);
        		} 
        		else if (Board.board[y][x] == "+") { //If the marker is the player
        			g.setColor(Color.black);
        			g.fillOval(xPaint,  yPaint,  width, height);
        		} 
        		else if (Board.board[y][x] == "-") { //If the marker is an empty space
        			g.setColor(Color.white);
        			g.fillRect(xPaint,  yPaint,  width, height);
        		} else if (Board.board[y][x].startsWith("M")) { //If the marker is a Mho
        			g.setColor(Color.blue);
        			g.drawRect(xPaint,  yPaint,  width, height);
        		}  
        	}
        }
        
        
    }


}



