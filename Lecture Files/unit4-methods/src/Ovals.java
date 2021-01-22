import javax.swing.*;
import java.awt.*;

public class Ovals extends JFrame {
    int x, y, ovalSize;
    //create constants to avoid magic numbers
    public static void main(String[]args){
        Ovals frame=new Ovals();
        frame.setSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        //invoke or make a call to
        // randomOvals with the values from thevariables.
        randomizeVariables(75,250);
        System.out.println("X: "+x+" Y: "+ y+" Size: "+ ovalSize);
        Color ovalColor=makeRandomColor();
        randomOvals(x,y, ovalSize, g, ovalColor);
        //reset the values held in the variables with new randoms
        randomizeVariables(25, 150);
        //Make call to randomOvals again with new values.
        // This will draw the ovals
        // in new locations with new height and width.
        randomOvals(x,y, ovalSize, g,makeRandomColor());
    }

    public void randomizeVariables(int minH, int maxH){
        //initialize my variables.
        int maxX, maxY, minX, minY;
        ovalSize =(int)(minH+(Math.random()*(maxH-minH+1)));

        minX=0;
        minY=0;

        maxX=getWidth()- ovalSize;
        maxY=getHeight()- ovalSize;

        x=(int)(Math.random()*(maxX-minX+1)+minX);
        y=(int)(Math.random()*(maxY-minY+1)+minY);
        System.out.println("X:"+x+"Y:"+y);

    }

    //method to draw an oval
    public void randomOvals(int x, int y, int size, Graphics g, Color color)
    {
        g.setColor(color);
        System.out.println("X: "+x+" Y: "+ y+" Size: "+ size);
        g.drawOval(x, y, size, size);
        //I am using the x, y , ovalSize, and w and setting them
        // relative to theoriginal values.
        g.drawOval((int)(x + size*.25), (int)(y + size*.25),(int)(size - size*.85), (int)(size - size*.85));
    }
    public Color makeRandomColor(){
        int r=(int)(Math.random()*256);
        int gr=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        Color eyeColor=new Color(r, gr, b);
        return eyeColor;
    }
}