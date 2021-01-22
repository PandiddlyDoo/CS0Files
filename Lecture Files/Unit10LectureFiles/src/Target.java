import javax.swing.*;
import java.awt.*;

/**
 * Created by cgorrill on 3/18/2016.
 */
public class Target extends JPanel {
    int height, width;
    final int X_ORIGIN = 20, Y_ORIGIN = 20;
    final int RING_WIDTH = 15;
    final int MAX_CIRCLES;
    Color c1=Color.RED;
    Color c2=Color.WHITE;

    public Target(int w, int h) {
        height = h;
        width = w;
        setPreferredSize(new Dimension(width, height));
        MAX_CIRCLES = width / RING_WIDTH;
        setBackground(Color.black);
    }

    public void swapColors(){
        Color temp=c1;
        c1=c2;
        c2=temp;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ringCount = 0;
        for (int i = 0; width - i * 2>0; i += RING_WIDTH) {
            if (ringCount % 2 == 0) {
                g2d.setColor(c1);
            } else {
                g2d.setColor(c2);
            }
            ringCount++;
            g2d.fillOval(X_ORIGIN+i, Y_ORIGIN+i, width - i * 2, height - i * 2);
        }
    }
}
