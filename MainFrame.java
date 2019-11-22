
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class MainFrame extends JFrame implements KeyListener{
    public static MainDraw draw;

    public final static int DIM = 3; //Dimensions
    
    public void keyPressed(KeyEvent e) {
    	System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {
    	
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        	Board.printBoard();
        	MainFrame.draw.repaint();
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
                frame.setTitle("HiVolts Game");
                frame.setResizable(false);
                frame.setSize(50 * DIM, 50 * DIM + 20);
                frame.setMinimumSize(new Dimension(1000, 600 + 20));
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



