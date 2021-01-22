import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClassBasics extends JFrame implements ActionListener {
    private final int FRAME_WIDTH=400;
    private final int FRAME_HEIGHT=600;
    private JPanel guiPanel;
    private DisplayPanel display;
    private JButton changeColor;
    private Color c;

    public static void main(String []args){
        InnerClassBasics frame=new InnerClassBasics();
        frame.setSize(new Dimension(400, 600));
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
        changeColor =new JButton("change color");
        changeColor.addActionListener(this);
        guiPanel.add(changeColor);
        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int r=(int)(Math.random()*256);
        int g=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        c=new Color(r,g,b);
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-200));
            this.setBackground(Color.WHITE);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(c);
            g.drawOval(0,0,100,100);
        }
    }
}
