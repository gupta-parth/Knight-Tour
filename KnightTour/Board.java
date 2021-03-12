import javax.swing.*;
import java.awt.*;

public class Board {
    char squares[][] = new char[8][8];
    ImageIcon pic;

    public Board() {
        pic = new ImageIcon("board1.png");
        squares[0][0] = 'x';
    }
    
    public void resetSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = 'o';
            }
        }
    }
    
    public void setInitSquare() {
        squares[0][0] = 'x';
    }
    
    public Boolean isTaken(int x, int y) {
        if (squares[x][y] == 'x') {
            return true;
        }
        return false;
    }
    
    public Boolean isOnBoard(int x, int y) {
        if (x <= 7 && x >= 0 && y <= 7 && y >= 0) {
            return true;
        }
        return false;
    }

    public Boolean isDone() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j] != 'x') {
                    return false;
                }
            }
        }
        return true;
    }

    public void draw(Container c, Graphics g) {
        pic.paintIcon(c, g, 5, 30);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j] == 'x') {
                    g.drawOval((i * 100 + 30), (j * 100 + 50), 50, 50);
                }
            }
        }
    }
}