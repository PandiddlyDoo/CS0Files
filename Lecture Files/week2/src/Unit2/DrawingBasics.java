package Unit2;

import javax.swing.*;
import java.awt.*;

public class DrawingBasics extends JFrame  {

    public static void main(String []args){
        DrawingBasics frame= new DrawingBasics();
        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        g.fillRect(10, 32, 100, 100);
        g.fillOval(160, 180, 300, 300);

        g.drawLine(10, 10, 150, 150);
    }

}
