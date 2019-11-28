
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;



public class MainFrame extends JFrame implements KeyListener{
    public static MainDraw draw;

    final static int FRAME_PADDING = 20;
    final static int TEXT_WIDTH = 400;
    
    Marker highlight = new Marker();
    
    public void keyPressed(KeyEvent e) {
    	System.out.println("keyPressed");
    }

    void updateVisuals() {
    	Board.printBoard(Board.gameBoard);
    	MainFrame.draw.repaint();
    }
    
    public void keyReleased(KeyEvent e) {
    	
        	if(e.getKeyCode() == KeyEvent.VK_UP) {
            	highlight.moveUp();
            	updateVisuals();
            } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            	highlight.moveDown();
            	updateVisuals();
            } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            	highlight.moveLeft();
            	updateVisuals();
            } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            	highlight.moveRight();
            	updateVisuals();
            } else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            	updateVisuals();
            } 
        
    }
    
    
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    public MainFrame(){
        this.draw = new MainDraw();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
    	
    	Board.init();
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
        	public void run() {
                
            	MainFrame frame = new MainFrame();
                frame.setTitle("TicTacToe Game");
                frame.setResizable(false);
                frame.setSize(200 * 3 + TEXT_WIDTH, 200 * 3 + FRAME_PADDING);
                frame.setMinimumSize(new Dimension(200 * 3 + TEXT_WIDTH, 200 * 3 + FRAME_PADDING));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
                
            }
        });
        
        
    }
    
    public void winScreen(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, 1000, 1000);
    	g.drawString("You won!", 480, 493);
    }
    
 
}
