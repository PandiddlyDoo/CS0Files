import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopBasics extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 650;
    private final int DISPLAY_HEIGHT = 100;

    private JPanel guiPanel;
    private DisplayPanel display;

    int num;
    int locX, locY;
    final int LIMIT=30;
    final int LETTER_SPACE =20;

    public static void main(String[] args) {
        LoopBasics frame = new LoopBasics();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.initializeVariables();

        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void initializeVariables(){
        num=1;
        locX=0;
        locY=DISPLAY_HEIGHT/2;
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
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            whileTest(g2d);
            //forTest(g2d);
        }

        public void whileTest(Graphics2D g2d){
            //modify this so that it will print out 1-100
            //each line will have only 30 numbers
            //hint, this will use if statements and a change in locY
            while(num<=LIMIT){
                g2d.drawString(num+", ", locX+num* LETTER_SPACE, locY);
                num++;
            }
        }

        public void forTest(Graphics2D g2d){
            //modify this so that each number alternates between green and red
            for(int i=1; i<=LIMIT; i++){
                g2d.drawString(i+", ", locX+i* LETTER_SPACE, locY);
            }
        }
    }
}


