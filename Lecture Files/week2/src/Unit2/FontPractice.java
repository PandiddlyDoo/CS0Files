package Unit2;

import javax.swing.*;
import java.awt.*;

public class FontPractice extends JFrame {
    public static void main(String[]args){
        FontPractice frame=new FontPractice();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d=(Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Font f=new Font("Sans-Serif", Font.BOLD, 36);

        g.setFont(f);
        g.drawString("Test Font!", 150, 250);


    }
}
