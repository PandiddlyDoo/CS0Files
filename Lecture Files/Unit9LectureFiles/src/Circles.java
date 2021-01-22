import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circles extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 600;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    private JPanel guiPanel;
    private DisplayPanel display;

    int originX, originY, circleSize;
    final double SCALE = .85;
    final int MIN_CIRCLE_SIZE = 10;


    public static void main(String[] args) {
        Circles frame = new Circles();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.initializeVariables();

        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void initializeVariables(){
        circleSize = DISPLAY_WIDTH / 2;
        originX = 0;
        originY = 0;
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

        public void tileTarget(int size, Graphics2D g2d) {
            for (int y = 0; y < this.getHeight(); y += size) {
                for (int x = 0; x < this.getWidth(); x += size) {
                    System.out.println("tile");
                    drawTarget(x, y, size, g2d);
                }
            }
        }

        public void drawTarget(int x, int y, int currentSize, Graphics2D g2d) {
            int startX = x;
            int startY = y;
            while (currentSize > MIN_CIRCLE_SIZE) {
                g2d.drawOval(x, y, currentSize, currentSize);
                //scale down the circles
                currentSize = (int) (currentSize * SCALE);

                //update the x and y origins for the circles
                x = startX + (circleSize - currentSize) / 2;
                y = startY + (circleSize - currentSize) / 2;
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            tileTarget(circleSize, g2d);
        }
    }
}


