import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IfBasics extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 400;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    private JPanel guiPanel;
    private DisplayPanel display;

    Color c;
    JTextField input;
    JButton submit;
    String response;


    public static void main(String[] args) {
        IfBasics frame = new IfBasics();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();

        frame.pack();
        frame.setVisible(true);
    }

    public void setColor(){
        if(response.equalsIgnoreCase("red"))
            c=Color.RED;
        else if(response.equalsIgnoreCase("yellow"))
            c=Color.YELLOW;
        else if(response.equalsIgnoreCase("blue"))
            c=Color.blue;
    }

    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());

        input=new JTextField("Red, Yellow, or blue");
        submit=new JButton("Submit");

        guiPanel.add(input);
        guiPanel.add(submit);

        submit.addActionListener(this);

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        response=input.getText();
        if (!(response.equalsIgnoreCase("red") ||
                response.equalsIgnoreCase("yellow") ||
                response.equalsIgnoreCase("blue"))) {
            input.setText("INVALID COLOR! Red, yellow, or blue");
        }else{
            setColor();
        }

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
            g.fillRect(100, 100, getWidth()-200, getHeight()-200);

        }
    }
}


