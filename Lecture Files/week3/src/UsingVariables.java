import javax.swing.*;
import java.awt.*;

public class UsingVariables extends JFrame {
    //instance variables can be used in all methods!
    int xOrigin, yOrigin, xEnd, yEnd, height, width;
    int xShift, yShift;
    String input;

    public static void main(String[] args) {
        UsingVariables frame = new UsingVariables();
        frame.setSize(new Dimension(600, 600));
        frame.setVisible(true);

        frame.getInputs();
        frame.height=frame.yOrigin+frame.yEnd;
        frame.width=frame.xOrigin+frame.xEnd;
        frame.repaint();


    }

    public void getInputs(){
        input=JOptionPane.showInputDialog(this, "enter the xOrigin origin for your box");
        xOrigin =Integer.parseInt(input);
        input=JOptionPane.showInputDialog(this, "enter the yOrigin origin for your box");
        yOrigin =Integer.parseInt(input);
        input=JOptionPane.showInputDialog(this, "enter the x for the lower right corner");
        xEnd =Integer.parseInt(input);
        input=JOptionPane.showInputDialog(this, "enter the y for the lower right corner");
        yEnd =Integer.parseInt(input);

        input=JOptionPane.showInputDialog(this, "enter the horizontal shift value");
        xShift =Integer.parseInt(input);
        input=JOptionPane.showInputDialog(this, "enter the vertical shift value");
        yShift =Integer.parseInt(input);

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fillRect(xOrigin, yOrigin, width, height);
        g2d.fillRect(xOrigin+xShift, yOrigin+yShift, width, height);


        //see if you can draw red X over the boxes using the variables available

    }


}

