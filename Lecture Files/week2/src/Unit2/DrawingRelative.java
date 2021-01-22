package Unit2;

import javax.swing.*;
import java.awt.*;

public class DrawingRelative extends JFrame {


    public static void main(String[] args) {
        DrawingRelative frame = new DrawingRelative();
        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void paint(Graphics g){
        super.paint(g);
        int frameW=getWidth();
        int frameH=getHeight();

        int w=frameW/3;
        int h=frameH/3;

        int xOffset=w/2;
        int yOffset=h/2;

        int x=frameW/2-xOffset;
        int y=frameH/2-yOffset;

        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
        g.setColor(Color.green);
        g.fillOval(x, y, w, h);
    }

}
