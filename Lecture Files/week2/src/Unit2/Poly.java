package Unit2;

import javax.swing.*;
import java.awt.*;

public class Poly extends JFrame {

    int xShift, yShift;

    public static void main(String[] args) {
        Poly frame = new Poly();
        frame.setSize(new Dimension(1024, 600));

        frame.xShift=250;
        frame.yShift=50;

        frame.setVisible(true);


    }

    public void paint(Graphics g){
        super.paint(g);

        Polygon poly=new Polygon();
        poly.addPoint(10+xShift,10+yShift);
        poly.addPoint(100+xShift,10+yShift);
        poly.addPoint(100+xShift,100+yShift);
        poly.addPoint(10+xShift,100+yShift);

        g.drawPolygon(poly);

    }
}