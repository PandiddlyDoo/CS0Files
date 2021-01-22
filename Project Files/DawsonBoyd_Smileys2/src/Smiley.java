/**Smiley2 Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */
import javax.swing.*;
import java.awt.*;

public class Smiley extends JPanel {
    int locX,locY, height, width;
    Color circleColor, eyesColor;
    boolean expression=true;

    //constructor for our smiles
    public Smiley(int x, int y, int h, int w){
        locX=x;
        locY=y;
        height=h;
        width=w;
        circleColor =Color.BLACK;
        eyesColor=Color.WHITE;
    }

    //Painting our smile. Code from first smiley project with the exception of a if/else for the frown.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //base oval
        g2d.setColor(circleColor);
        g2d.fillOval(locX, locY, height, width);
        //eyes
        g2d.setColor(eyesColor);
        g2d.fillOval((int)(locX + width*.25), (int)(locY + height*.25),(int)(width - height*.85), (int)(width - height*.85));
        g2d.fillOval((int)(locX + width*.6), (int)(locY + height*.25),(int)(width - height*.85), (int)(width - height*.85));
        //mouth
        if (expression) {
            g2d.fillArc((int) (locX + width * .17), (int) (locY + height * .25), (int) (width - height * .35),
                    (int) (width - height * .35), 180, 180);
        }else if (!expression){
            g2d.fillArc((int) (locX + width * .17), (int) (locY + height * .50), (int) (width - height * .35),
                    (int) (width - height * .35), 180, -180);
        }

    }

    //Radio buttons, base smile color. Lines 96-104 in SmileControl.
    public void setCircleColor(Color c){
        circleColor=c;
    }
    //single button random eye color. Lines 87-91 in SmileControl + makeRandomColor method from first project.
    public void setEyesColor(Color ec){
        eyesColor=ec;
    }
    //Buttons, size of smiley. Lines 79-86 in SmileControl.
    public void setSize(int size){
        height+=size;
        width+=size;
    }
    //Combo box, smile/frown. Lines 106-114 in SmileControl.
    public void setSmile(Boolean isSmiling){
        expression=isSmiling;
        System.out.println(expression);
    }

}
