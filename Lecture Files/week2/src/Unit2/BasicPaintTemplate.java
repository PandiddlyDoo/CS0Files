package Unit2;

import javax.swing.*;
import java.awt.*;

public class BasicPaintTemplate extends JFrame {

    public static void main(String[]args){
        BasicPaintTemplate frame=new BasicPaintTemplate();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        g.drawString("hello", 10, 40);
        g.drawOval(300, 300, 300, 300);
    }
}
