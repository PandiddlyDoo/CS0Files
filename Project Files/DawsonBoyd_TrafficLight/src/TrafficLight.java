/**Traffic Light Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight extends JFrame implements ActionListener {

    //Declaring many variables to use as constants
    private final int DISPLAY_WIDTH = 1000;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;
    private int outerRect = DISPLAY_WIDTH / 2;
    private int innerRect = DISPLAY_WIDTH / 3;
    private int lightSize = DISPLAY_WIDTH / 5;
    private JPanel guiPanel, topPanel;
    private JLabel title;
    private DisplayPanel display;
    private JButton stop, slow, go;
    private boolean isStop=true, isSlow, isGo;
    private Color c;
    private Timer timer;


    public static void main(String[] args) {
        TrafficLight frame = new TrafficLight();
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
        stop = new JButton("stop");
        stop.addActionListener(this);
        slow = new JButton("slow");
        slow.addActionListener(this);
        go = new JButton("go");
        go.addActionListener(this);
        guiPanel.add(stop);
        guiPanel.add(slow);
        guiPanel.add(go);
        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

        //Title JPanel in the north
        topPanel = new JPanel(new FlowLayout());
        title = new JLabel("Traffic Light");
        topPanel.add(title);
        window.add(topPanel, BorderLayout.NORTH);

    }

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

            //Background For light
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(DISPLAY_WIDTH / 2 - outerRect / 2, DISPLAY_HEIGHT / 2 - outerRect, outerRect, outerRect * 2);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(DISPLAY_WIDTH / 2 - outerRect / 3, DISPLAY_HEIGHT / 3 - outerRect / 2, innerRect, (int) (innerRect * 2.5));

            //Reusing c to draw backgrounds for light
            c = new Color(127, 0, 0);
            g2d.setColor(c);
            g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                    DISPLAY_HEIGHT / 2 - (int) (lightSize * 1.75),
                    lightSize, lightSize);
            c = new Color(130, 100, 0);
            g2d.setColor(c);
            g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                    DISPLAY_HEIGHT / 2 - lightSize / 2,
                    lightSize, lightSize);
            c = new Color(6, 89, 0);
            g2d.setColor(c);
            g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                    DISPLAY_HEIGHT / 2 + (int) (lightSize / 1.35),
                    lightSize, lightSize);

            //If/else statement changes light color default red
            if (isStop) {
                g2d.setColor(Color.RED);
                g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                        DISPLAY_HEIGHT / 2 - (int) (lightSize * 1.75),
                        lightSize, lightSize);
            } else if (isSlow) {
                g2d.setColor(Color.YELLOW);
                g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                        DISPLAY_HEIGHT / 2 - lightSize / 2,
                        lightSize, lightSize);
            } else if (isGo) {
                g2d.setColor(Color.GREEN);
                g2d.fillOval(DISPLAY_WIDTH / 2 - lightSize / 2,
                        DISPLAY_HEIGHT / 2 + (int) (lightSize / 1.35),
                        lightSize, lightSize);
            }

        }
    }
    //actionPerformed to detect button presses
    //This section could have been made cleaner with a switch statement but I wanted to make sure I used boolean flags
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stop) {
            isStop = true;
            isSlow = false;
            isGo = false;
        } else if (e.getSource() == slow) {
            isStop = false;
            isSlow = true;
            isGo = false;
        } else if (e.getSource() == go) {
            isStop = false;
            isSlow = false;
            isGo = true;
        }
        display.repaint();
    }


}



