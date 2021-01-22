import javax.swing.*;
import java.awt.*;

public class LayoutBasics extends JFrame {
    private JPanel top, bottom, left, right, center;
    private JLabel topLabel, bottomLabel, leftLabel, rightLabel, centerLabel;
    public static void main(String[]args){
        LayoutBasics frame=new LayoutBasics();
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    public void createGUI(){
        Container window=getContentPane();
        //make panels
        top=new JPanel(new FlowLayout());
        top.setBackground(Color.CYAN);
        bottom=new JPanel(new FlowLayout());
        bottom.setBackground(Color.CYAN);
        left=new JPanel(new FlowLayout());
        left.setBackground(Color.YELLOW);
        right=new JPanel(new FlowLayout());
        right.setBackground(Color.YELLOW);
        center=new JPanel(new FlowLayout());
        center.setBackground(Color.PINK);

        //make labels
        topLabel=new JLabel("TOP");
        bottomLabel=new JLabel("BOTTOM");
        leftLabel=new JLabel("LEFT");
        rightLabel=new JLabel("RIGHT");
        centerLabel=new JLabel("CENTER");

        //add labels to panels
        top.add(topLabel);
        bottom.add(bottomLabel);
        left.add(leftLabel);
        right.add(rightLabel);
        center.add(centerLabel);

        //add panels to frame
        window.add(top, BorderLayout.NORTH);
        window.add(bottom, BorderLayout.SOUTH);
        window.add(left, BorderLayout.WEST);
        window.add(right, BorderLayout.EAST);
        window.add(center, BorderLayout.CENTER);


        /*
        * Let's update this thing!
        * Give it a set of labels and fields to input
        * first and last name in the east.  Then add a submit
        * button to the south.
        * See if you can figure out how to make a text area in the center
        * and then try to get the text from teh fields and
        * output it to the text area.
        * */


    }
}
