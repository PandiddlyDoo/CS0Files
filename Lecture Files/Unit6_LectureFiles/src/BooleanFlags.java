import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BooleanFlags extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH =400;
    private final int DISPLAY_HEIGHT =DISPLAY_WIDTH;
    private int circleSize =DISPLAY_WIDTH/2;
    private JPanel guiPanel;
    private DisplayPanel display;
    private JButton stop, slow, go;
    private boolean isStop=true, isSlow, isGo, isCircle=true;
    private Color c;

    public static void main(String []args){
        BooleanFlags frame=new BooleanFlags();
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
        stop =new JButton("stop");
        stop.addActionListener(this);
        slow =new JButton("slow");
        slow.addActionListener(this);
        go =new JButton("go");
        go.addActionListener(this);
        guiPanel.add(stop);
        guiPanel.add(slow);
        guiPanel.add(go);
        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==stop){
            isStop=true;
            isSlow=false;
            isGo=false;
        }
        else if(e.getSource()==slow){
            isStop=false;
            isSlow=true;
            isGo=false;
        }
        else if(e.getSource()==go){
            isStop=false;
            isSlow=false;
            isGo=true;
        }
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            if(isStop){
                c=Color.RED;
            }
            else if(isSlow){
                c=Color.YELLOW;
            }
            else if(isGo){
                c=Color.GREEN;
            }

            g.setColor(c);
            if(isCircle) {
                g.fillOval(DISPLAY_WIDTH / 2 - circleSize / 2,
                        DISPLAY_HEIGHT / 2 - circleSize / 2,
                        circleSize, circleSize);
            }

        }
    }
}


