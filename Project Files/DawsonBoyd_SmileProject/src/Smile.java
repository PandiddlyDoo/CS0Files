/**Smiley Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;

public class Smile extends JFrame {
    //create constants to avoid magic numbers
    int locX, locY, size;

    public static void main(String[]args){
        Smile frame=new Smile();
        frame.setSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Smile!");
        frame.setVisible(true);


    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
;
        //For loop for scalability instead of copy pasting
        //This isn't entirely necessary but it makes this method much smaller. It's also fun setting it really high.
        for(int i=1; i<=30; i++) {

            randomizeVariables(25, 150);
            Color headColor = makeRandomColor();
            Color eyeColor = makeRandomColor();
            drawSmileyFace(locX, locY, size, headColor, eyeColor, g2d);

        }

    }

    public void randomizeVariables(int minH, int maxH){
        //initialize my variables.
        int maxX, maxY, minX, minY;
        size =(int)(minH+(Math.random()*(maxH-minH+1)));

        //Setting min and max to account for frame
        minX=8;
        minY=31;

        maxX=getWidth() - size - 8;
        maxY=getHeight() - size - 8;

        locX=(int)(Math.random()*(maxX-minX+1)+minX);
        locY=(int)(Math.random()*(maxY-minY+1)+minY);

    }

    //method to draw an Smile
    public void drawSmileyFace(int locX, int locY, int size, Color headColor, Color eyeColor, Graphics g2d) {

        //base oval
        g2d.setColor(headColor);
        g2d.fillOval(locX, locY, size, size);
        //eyes
        g2d.setColor(eyeColor);
        g2d.fillOval((int)(locX + size*.25), (int)(locY + size*.25),(int)(size - size*.85), (int)(size - size*.85));
        g2d.fillOval((int)(locX + size*.6), (int)(locY + size*.25),(int)(size - size*.85), (int)(size - size*.85));
        //mouth
        g2d.fillArc((int)(locX + size*.17), (int)(locY + size*.25),(int)(size - size*.35), (int)(size - size*.35), 180, 180);

    }

    //random color method
    public Color makeRandomColor(){
        int r=(int)(Math.random()*256);
        int gr=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        Color color=new Color(r, gr, b);
        return color;
    }


}