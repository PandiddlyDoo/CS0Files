import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IfElseBasics extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH =400;
    private final int DISPLAY_HEIGHT =DISPLAY_WIDTH;
    private int xShift=0, yShift=0;
    private int circleSize =DISPLAY_WIDTH/2;
    private JPanel guiPanel;
    private DisplayPanel display;
    private JButton changeColor, bigger, smaller, up, down, left, right;
    private Color c;

    public static void main(String []args){
        IfElseBasics frame=new IfElseBasics();
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

        bigger =new JButton("bigger");
        bigger.addActionListener(this);
        smaller =new JButton("smaller");
        smaller.addActionListener(this);
        up =new JButton("up");
        up.addActionListener(this);
        down =new JButton("down");
        down.addActionListener(this);
        left =new JButton("left");
        left.addActionListener(this);
        right =new JButton("right");
        right.addActionListener(this);

        guiPanel.add(changeColor);
        guiPanel.add(bigger);
        guiPanel.add(smaller);

        guiPanel.add(up);
        guiPanel.add(down);
        guiPanel.add(left);
        guiPanel.add(right);

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == changeColor) {
            c = makeRandomColor();
        }
        else if(e.getSource()==bigger){
            circleSize=circleSize+10;
        }
        else if(e.getSource()==smaller){
            circleSize-=10;
        }
        else if(e.getSource()==up){
            yShift-=10;
        }else if(e.getSource()==down){
            yShift+=10;
        }else if(e.getSource()==left){
            xShift-=10;
        }else if(e.getSource()==right){
            xShift+=10;
        }

        display.repaint();
    }

    public Color makeRandomColor(){
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r,g,b);
    }

    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(c);
            g.fillOval(xShift+DISPLAY_WIDTH/2- circleSize /2,
                    yShift+DISPLAY_HEIGHT/2- circleSize /2,
                    circleSize, circleSize);
        }
    }//close DisplayPanel
}//close IfElseBasics