/** Measuring Distance Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;

    public class Measuring extends JFrame {
        //instanced variables
        int line1X1, line1X2, line1Y1, line1Y2, line2X1, line2X2, line2Y1, line2Y2;
        String input;
        double line1Distance, line2Distance;

        // Main method drawing frame and gathering inputs
        public static void main(String[] args) {
            Measuring frame = new Measuring();
            frame.setSize(new Dimension(600, 600));
            frame.setTitle("Measuring Distance");
            frame.setVisible(true);
            frame.getInputs();
            frame.repaint();


        }

        // reusing string "input" to save on memory
        public void getInputs() {

            //Line 1
            input = JOptionPane.showInputDialog(this, "Line 1 starting point X");
            line1X1 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 1 starting point Y");
            line1Y1 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 1 ending point X");
            line1X2 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 1 ending point Y");
            line1Y2 = Integer.parseInt(input);

            //Line 2
            input = JOptionPane.showInputDialog(this, "Line 2 starting point X");
            line2X1 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 2 starting point Y");
            line2Y1 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 2 ending point X");
            line2X2 = Integer.parseInt(input);
            input = JOptionPane.showInputDialog(this, "Line 2 ending point Y");
            line2Y2 = Integer.parseInt(input);

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            //Lines themselves
            g2d.drawLine(line1X1, line1Y1, line1X2, line1Y2);
            g2d.drawLine(line2X1, line2Y1, line2X2, line2Y2);

            //Drawing label Strings
            String line1Start="Line 1 Start: "+"("+line1X1+", "+line1Y1+")";
            String line1End="Line 1 End: "+"("+line1X2+", "+line1Y2+")";
            String line2Start="Line 2 Start: "+"("+line2X1+", "+line2Y1+")";
            String line2End="Line 2 End: "+"("+line2X2+", "+line2Y2+")";

            g2d.drawString(line1Start, line1X1+10, line1Y1);
            g2d.drawString(line1End, line1X2+10, line1Y2);
            g2d.drawString(line2Start, line2X1+10, line2Y1);
            g2d.drawString(line2End, line2X2+10, line2Y2);

            //Calculating distance between points
            line1Distance=Math.sqrt((line1X2-line1X1)*(line1X2-line1X1) + (line1Y2-line1Y1)*(line1Y2-line1Y1));
            line2Distance=Math.sqrt((line2X2-line2X1)*(line2X2-line2X1) + (line2Y2-line2Y1)*(line2Y2-line2Y1));

            //Drawing distance string
            String line1Length="Line 1 Length: "+"("+line1Distance+")";
            String line2Length="Line 2 Length: "+"("+line2Distance+")";
            g2d.drawString(line1Length, 30, 550);
            g2d.drawString(line2Length, 30, 570);

            //Length Comparison
            if (line1Distance > line2Distance) {

                g2d.drawString("Line 1 is longer", 400, 550);
            }

            else if (line1Distance < line2Distance) {

                g2d.drawString("Line 2 is longer", 400, 550);
            }

            else {
                //Unlikely but thought id throw it in if you try :D
                g2d.drawString("The lines are equal", 400, 550);
            }


        }

    }

