package Unit2;

import javax.swing.*;
import java.awt.*;

public class DrawingArcs extends JFrame {


    public static void main(String[] args) {
        DrawingArcs frame = new DrawingArcs();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawArc(10, 40, 100, 100, 0, 180);
        g.drawArc(120, 40, 100, 100, 180, 180);
        g.drawArc(230, 40, 100, 100, 90, 180);
        g.drawArc(250, 40, 100, 100, 90, -180);

        g.setColor(Color.PINK);
        g.fillArc(10, 150, 100, 100, 180, -180);
        g.fillArc(120, 150, 100, 100, 0, -180);
        g.fillArc(230, 150, 100, 100, 270, -180);
        g.fillArc(250, 150, 100, 100, 270, 180);

        g.setColor(Color.blue);
        g.fillArc(50, 150, 200, 200, 0, -18 );
    }

}
