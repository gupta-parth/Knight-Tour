import javax.swing.*;
import java.awt.*;

public class Game extends JFrame implements Runnable {
    Knight knight = new Knight();
    Board board = new Board();
    int replayCounter = 0;
    
    Thread myThread;
    
    Boolean gameDone = false;

    public Game() {
        super("Knight's tour");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        setSize(812,835);
        setVisible(true);
        // Add a thread here to make the knight move on its own
        // Thread will call move until the knight hits a dead end or a path has been found
        if (myThread == null) {
            myThread = new Thread(this);
            myThread.start();
        }
        
        repaint();
        
        
    }
    
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thisThread == myThread) {
            if (!gameDone) {        // While successful path hasn't been found
                try {
                    Thread.sleep(400);
                }
                catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
                Boolean k = knight.move(board);
                if (k == false) {       
                    if (board.isDone()) {       // If stuck and successful path has been found
                        gameDone = true;        // Break out of the statement
                        board.resetSquares();
                        System.out.println("Found path");
                        
                    }
                    else  {         // Otherwise path not found, reset everything
                        board.resetSquares();
                        knight.resetKnight(board);
                    }
                    repaint();
                    
                }
                else repaint();     // Keep drawing if not stuck
            }
            
            else {      // When path found
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
                
                knight.replayMove(replayCounter);
                replayCounter++;
                if (replayCounter == 63) {
                    if (myThread != null) myThread = null;
                }
                repaint();
            }
            
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        board.draw(this, g);
        knight.draw(this, g);
    }
    
    public static void main(String args[]) {
        Game game = new Game();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
