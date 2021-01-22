import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClassTemplate extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH =400;
    private final int DISPLAY_HEIGHT =DISPLAY_WIDTH;

    private JPanel guiPanel;
    private DisplayPanel display;


    public static void main(String []args){
        InnerClassTemplate frame=new InnerClassTemplate();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpGUI(){
        Container window=getContentPane();
        display=new DisplayPanel();
        guiPanel=new JPanel(new FlowLayout());

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }
        public void paintComponent(Graphics g){

        }
    }
}


