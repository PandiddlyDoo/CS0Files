import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* //make a framed application that will display a letter grade for a student
    //You will use if/else to solve this problem.
    //the frame will also paint a large rectangle with the following color:
        //if the grade is an A the rectangle with be green
        //if the grade is a B the color is yellow
        //if the grade is a C the color is orange
        //if the grade is a D the color is red
        //if the grade is an F the color is magenta
**/

public class Grades extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 400;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    private JPanel guiPanel;
    private DisplayPanel display;


    public static void main(String[] args) {
        Grades frame = new Grades();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {

        }
    }
}


