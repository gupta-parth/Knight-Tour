import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Knight {
    int posX = 0;
    int posY = 0;
    int priority[][] = new int[8][8];
    Random rand = new Random();
    ImageIcon pic;
    
    Point path[] = new Point[64];     // For path storage
    int index = 1;

    public Knight() {
        pic = new ImageIcon("unnamedEdit.png");
        posX = 0;
        posY = 0;
        path[0] = new Point(posX, posY);

        // Corners
        priority[0][7] = 1;
        priority[7][0] = 1;
        priority[7][7] = 1;

        // Edges
        priority[0][1]=2;  
        priority[0][2]=2;
        priority[0][3]=2;
        priority[0][4]=2;
        priority[0][5]=2;
        priority[0][6]=2;
        priority[1][0]=2;
        priority[2][0]=2;
        priority[3][0]=2;
        priority[4][0]=2;
        priority[5][0]=2;
        priority[6][0]=2;
        priority[7][1]=2;
        priority[7][2]=2;
        priority[7][3]=2;
        priority[7][4]=2;
        priority[7][5]=2;
        priority[7][6]=2;
        priority[1][7]=2;
        priority[2][7]=2;
        priority[3][7]=2;
        priority[4][7]=2;
        priority[5][7]=2;
        priority[6][7]=2;

        priority[1][1]=3;
        priority[1][2]=3;
        priority[1][3]=3;
        priority[1][4]=3;
        priority[1][5]=3;
        priority[1][6]=3;
        priority[2][6]=3;
        priority[3][6]=3;
        priority[4][6]=3;
        priority[5][6]=3;
        priority[6][6]=3;
        priority[6][5]=3;
        priority[6][4]=3;
        priority[6][3]=3;
        priority[6][2]=3;
        priority[6][1]=3;
        priority[5][1]=3;
        priority[4][1]=3;
        priority[3][1]=3;
        priority[2][1]=3;

        // Middle
        priority[2][2]=4;
        priority[2][3]=4;
        priority[2][4]=4;
        priority[2][5]=4;
        priority[3][5]=4;
        priority[4][5]=4;
        priority[5][5]=4;
        priority[5][4]=4;
        priority[5][3]=4;
        priority[5][2]=4;
        priority[4][2]=4;
        priority[3][2]=4;
        priority[3][3]=4;
        priority[3][4]=4;
        priority[4][4]=4;
        priority[4][3]=4;

    }
    
    public void resetKnight(Board chessBoard) {
        posX = 0;
        posY = 0;
        chessBoard.setInitSquare();
        for (int i = 0; i < 64; i++) {
            path[i] = null;
        }
        index = 0;
    }
    
    public void replayMove(int i) {
        posX = path[i].x;
        posY = path[i].y;
    }
    public Boolean move(Board chessBoard) {
        int moveX = 0;
        int moveY = 0;
        int num;
        Boolean good = false;
        
        for (int i = 0; i < 300; i++) {
            num = rand.nextInt(8);
            if (num == 0) {
                moveX = 2;
                moveY = 1;
            }
            else if (num == 1) {
                moveX = 2;
                moveY = -1;
            }
            else if (num == 2) {
                moveX = -2;
                moveY = 1;
            }
            else if (num == 3) {
                moveX = -2;
                moveY = -1;
            }
            else if (num == 4) {
                moveX = 1;
                moveY = 2;
            }
            else if (num == 5) {
                moveX = 1;
                moveY = -2;
            }
            else if (num == 6) {
                moveX = -1;
                moveY = 2;
            }
            else if (num == 7) {
                moveX = -1;
                moveY = -2;
            }

            if (chessBoard.isOnBoard(posX + moveX, posY + moveY) == true && chessBoard.isTaken(posX + moveX, posY + moveY) == false) {
                if (priority[posX + moveX][posY + moveY] == 1) {
                    posX += moveX;
                    posY += moveY;
                    path[index] = new Point(posX, posY);
                    index++;
                    chessBoard.squares[posX][posY] = 'x';
                    good = true;
                    break;
                }
                else if (i > 70 && priority[posX + moveX][posY + moveY] == 2) {
                    posX += moveX;
                    posY += moveY;
                    path[index] = new Point(posX, posY);
                    index++;
                    chessBoard.squares[posX][posY] = 'x';
                    good = true;
                    break;
                }
                else if (i > 160 && priority[posX + moveX][posY + moveY] == 3) {
                    posX += moveX;
                    posY += moveY;
                    path[index] = new Point(posX, posY);
                    index++;
                    chessBoard.squares[posX][posY] = 'x';
                    good = true;
                    break;
                }
                else if (i > 250 && priority[posX + moveX][posY + moveY] == 4) {
                    posX += moveX;
                    posY += moveY;
                    path[index] = new Point(posX, posY);
                    index++;
                    chessBoard.squares[posX][posY] = 'x';
                    good = true;
                    break;
                }
                
            }

            /*
            if (chessBoard.isOnBoard(posX + moveX, posY + moveY) == true && chessBoard.isTaken(posX + moveX, posY + moveY) == false) {
                posX += moveX;
                posY += moveY;
                chessBoard.squares[posX][posY] = 'x';
                path[index] = new Point(posX, posY);
                index++;
                good = true;
                break;
            }
            */
        }
        if (good == false) {
            return false;
        }
        else return true;
    }

    
    public void draw(Container c, Graphics g) {
        pic.paintIcon(c, g, (posX * 100) + 20, (posY * 100) + 40);
    }
}


class Point {         // A class to store points
    int x;
    int y;
    public Point(int xcoord, int ycoord) {
        x = xcoord;
        y = ycoord;
    }
}