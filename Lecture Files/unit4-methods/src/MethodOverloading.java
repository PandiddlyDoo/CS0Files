import javax.swing.*;
import java.awt.*;

public class MethodOverloading extends JFrame {
    int x, y, h;
    //create constants to avoid magic numbers
    public static void main(String[]args){
        MethodOverloading frame=new MethodOverloading();
        frame.setSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.updateVariables();

        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        //invoke or make a call to
        // randomOvals with the values from thevariables.
        System.out.println("X: "+x+" Y: "+ y+" Size: "+ h);
        randomOvals(x,y,h, g,makeRandomColor());
        //reset the values held in the variables with new randoms
        updateVariables();
        //Make call to randomOvals again with new values.
        // This will draw the ovals
        // in new locations with new height and width.
        randomOvals(x,y,h, g,makeRandomColor());
        randomOvals(g, makeRandomColor());
        randomOvals(g);

    }

    public void updateVariables(){
        //initialize my variables.
        x=(int)(Math.random()*300)+1;
        y=(int)(Math.random()*300)+1;
        h=(int)(150+(Math.random()*(300-150))+1);
        System.out.println("X:"+x+"Y:"+y);

    }

    //method to draw an oval
    public void randomOvals(int x, int y, int size, Graphics g, Color color)
    {
        g.setColor(color);
        System.out.println("randomOvals(x,y,h, g,makeRandomColor()) X: "+x+" Y: "+ y+" Size: "+ size);
        g.drawOval(x, y, size, size);
        //I am using the x, y , h, and w and setting them
        // relative to theoriginal values.
        g.drawOval((int)(x + size*.10), (int)(y + size*.10),(int)(size - size*.20), (int)(size - size*.20));
    }

    public void randomOvals(Graphics g, Color color)
    {
        updateVariables();
        g.setColor(color);
        System.out.println("randomOvals(Graphics g, Color color) X: "+x+" Y: "+ y+" Size: "+ h);
        g.drawOval(x, y, h, h);
        //I am using the x, y , h, and w and setting them
        // relative to theoriginal values.
        g.drawOval((int)(x + h*.10), (int)(y + h*.10),(int)(h - h*.20), (int)(h - h*.20));
    }

    public void randomOvals(Graphics g)
    {
        updateVariables();
        g.setColor(makeRandomColor());
        System.out.println("randomOvals(Graphics g, Color color) X: "+x+" Y: "+ y+" Size: "+ h);
        g.drawOval(x, y, h, h);
        //I am using the x, y , h, and w and setting them
        // relative to theoriginal values.
        g.drawOval((int)(x + h*.10), (int)(y + h*.10),(int)(h - h*.20), (int)(h - h*.20));
    }

    public Color makeRandomColor(){
        int r=(int)(Math.random()*256);
        int gr=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        Color eyeColor=new Color(r, gr, b);
        return eyeColor;
    }
}
