/**Elevator Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Elevator extends JFrame implements ActionListener {

    //Declaring many variables to use as constants
    private final int DISPLAY_HEIGHT = 800;
    private final int DISPLAY_WIDTH = DISPLAY_HEIGHT/2;
    private int lightSize = DISPLAY_WIDTH / 5;
    private JPanel guiPanel;
    private DisplayPanel display;
    private JButton go;
    private Color c;
    private int floorHeight, floorY;
    private int floorWidth, floorX;
    JComboBox choiceBox;
    private int choice=1; //Choice is set to 1 so the elevator doesen't start in the ground


    public static void main(String[] args) {
        Elevator frame = new Elevator();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpGUI() {

        //Creating buttons and layout
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());
        choiceBox = new JComboBox();
        go = new JButton("go");
        go.addActionListener(this);
        guiPanel.add(go);
        guiPanel.add(choiceBox);
        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

        for (int i = 0; i < 10; i++) {
            choiceBox.addItem(String.valueOf(i + 1));
        }

        choiceBox.addActionListener(this);
    }


    //Innerclass to extend JPanel to paint
    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }


        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            //The "Ground and sky"
            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
            g2d.setColor(Color.CYAN);
            g2d.fillRect(DISPLAY_WIDTH-DISPLAY_WIDTH, DISPLAY_HEIGHT-DISPLAY_HEIGHT, DISPLAY_WIDTH, DISPLAY_HEIGHT - DISPLAY_HEIGHT/5);

            //Setting my variables in reference to the frame

            floorHeight = DISPLAY_HEIGHT - DISPLAY_HEIGHT / 5;
            floorY= DISPLAY_HEIGHT - DISPLAY_HEIGHT / 5;
            floorWidth = DISPLAY_WIDTH - 30;
            floorX = 0;

            //Nested loops to create the stories and windows
            for (int i=0; i<10; i++) {
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(30, floorY, floorWidth - 30, 70);
               floorY = floorY-70;
               floorX=0;

               for(int k=0; k<6; k++) {
                    c = new Color(130, 100, 0);
                    g2d.setColor(c);

                    g2d.fillRect(floorX+60, floorY + 75, 40, floorHeight / 12);

                    floorX=floorX+50;

                }

            }
            //Uses the choice from JComboBox to draw the elevator similar to traffic light project
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(60, floorHeight+75-(choice*70), 40, floorHeight/12);


        }
    }
    //actionPerformed to detect button press and write the comboBox choice to choice
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == go) {
             choice = Integer.parseInt((String) choiceBox.getSelectedItem());

        }
        display.repaint();
    }


}
