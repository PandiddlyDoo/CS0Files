import javax.swing.*;
import java.awt.*;

/**
 * Created by Charlie Gorrill on 3/22/2016.
 */
public class CheckerPattern extends JPanel{
    final int NUM_ROWS=8;
    boolean isBlack=true;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(int row=0; row<getHeight(); row++){
            for(int col=0; col<getWidth(); col++){
                pickColor(g2d, row);
                g2d.fillRect(col*getWidth()/NUM_ROWS, row*getHeight()/NUM_ROWS, getWidth()/NUM_ROWS, getHeight()/NUM_ROWS);
            }//inner for
        }//outer for
    }

    public void pickColor(Graphics g, int row){
        if(row%2==0) {
            if (isBlack) {
                g.setColor(Color.BLACK);
                isBlack = false;
            } else {
                g.setColor(Color.RED);
                isBlack = true;
            }
        }
        else{
            if(!isBlack){
                g.setColor(Color.BLACK);
                isBlack = true;
            }
            else{
                g.setColor(Color.RED);
                isBlack = false;
            }

        }
    }
}
