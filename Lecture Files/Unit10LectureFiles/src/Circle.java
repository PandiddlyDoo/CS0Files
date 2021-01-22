import javax.swing.*;
import java.awt.*;

/**
 * Created by Charlie Gorrill on 3/22/2016.
 */
public class Circle extends JPanel{
    int locx,locy, height, width;
    Color circleColor;

    public Circle(int x, int y, int h, int w){
        locx=x;
        locy=y;
        height=h;
        width=w;
        circleColor =Color.BLACK;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(circleColor);
        g2d.fillOval(locx,locy,height, width);
    }

    public void setCircleColor(Color c){
        circleColor=c;
    }

    public void setSize(int size){
        height+=size;
        width+=size;
    }


}
