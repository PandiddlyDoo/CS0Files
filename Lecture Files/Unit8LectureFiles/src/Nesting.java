import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nesting extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 400;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    JButton randomize;

    private JPanel guiPanel;
    private DisplayPanel display;

    int num, min = 65, max = 89;
    char ch;
    Color c;

    public static void main(String[] args) {
        Nesting frame = new Nesting();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();

        frame.pickColor();

        frame.pack();
        frame.setVisible(true);
    }

    public void pickColor() {
        num = min + (int) (Math.random() * (max - min) + 1);
        ch = (char) (min + (int) (Math.random() * (max - min) + 1));
        if (num % 2 == 0) {
            if (ch < 'F') {
                c = Color.MAGENTA;
            }
            else if (ch < 'N') {
                c = Color.ORANGE;
            }
            else
                c= Color.GREEN;
        }
        else{
            if(ch>'T'){
                c=Color.CYAN;
            }
            if(ch>'O'){
                c=Color.BLUE;
            }
            else
                c=Color.YELLOW;
        }

        System.out.printf("Num: %d%nCh: %c%n", num, ch);

    }

    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());

        randomize=new JButton("randomize");
        randomize.addActionListener(this);

        guiPanel.add(randomize);

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pickColor();
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(c);

            g.fillOval(50,50,getWidth()-100, getHeight()-100);
        }
    }
}


