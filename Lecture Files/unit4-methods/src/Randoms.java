import javax.swing.*;
import java.awt.*;

public class Randoms extends JFrame {
    double dNum1, dNum2;
    int iNum;
    int min, max;
    int x,y, height, width;

    public static void main(String[]args){
        Randoms frame=new Randoms();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setVisible(true);

        frame.min=25;
        frame.max=475;
        frame.dNum1=Math.random();
        frame.dNum2=Math.random()*6;
        frame.iNum=frame.min+(int)(Math.random()*(frame.max-frame.min+1));

        frame.min=0;
        frame.max=350;
        frame.x=frame.min+(int)(Math.random()*(frame.max-frame.min+1));
        frame.y=frame.min+(int)(Math.random()*(frame.max-frame.min+1));

        frame.max=250;
        frame.min=80;
        frame.height=frame.min+(int)(Math.random()*(frame.max-frame.min+1));
        frame.width=frame.height;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString(""+dNum1,50,50);
        g2d.drawString(""+dNum2,50,75);
        g2d.drawString(""+iNum,50,90);
        g2d.fillOval(x,y,width,height);
    }

}
