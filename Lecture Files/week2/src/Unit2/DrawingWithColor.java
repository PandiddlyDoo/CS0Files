package Unit2;

import javax.swing.*;
import java.awt.*;

public class DrawingWithColor extends JFrame {

    public static void main(String[] args) {
        DrawingWithColor frame = new DrawingWithColor();
        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void paint(Graphics g){
        super.paint(g);

        g.setColor(Color.green);
        g.fillRect(150, 150, 300, 300);
        g.setColor(Color.red);
        g.fillOval(150, 150, 300, 300);


    }
}
