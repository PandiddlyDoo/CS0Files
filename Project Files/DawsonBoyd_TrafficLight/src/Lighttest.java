/*TrafficLight Project*
 * @author Murtadha Al-Sultan*
 * @version Fall 2020*
 * CSci 1130 Professor Charles J Gorrill*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lighttest extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH =400;
    private final int DISPLAY_HEIGHT =DISPLAY_WIDTH;
    private final int ovalSize =DISPLAY_WIDTH/2;
    private JPanel guiButtons, topTitle;
    private JLabel topLabel;
    private DisplayPanel display;
    private JButton red, yellow, green;
    private boolean isRed=true, isGreen, isYellow;
    private Graphics2D g2d;

    public static void main(String []args){
        Lighttest frame=new Lighttest();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }
    //create panel that with title that contains action listener buttons & added window to make them visible & jLabel
    public void setUpGUI(){
        Container window=getContentPane();
        display=new DisplayPanel();
        topTitle =new JPanel(new FlowLayout());
        topLabel=new JLabel("Traffic Light");
        topTitle.add(topLabel);
        guiButtons =new JPanel(new FlowLayout());
        red =new JButton("Stop");
        red.addActionListener(this);
        yellow =new JButton("Slow");
        yellow.addActionListener(this);
        green =new JButton("Go");
        green.addActionListener(this);

        guiButtons.add(red);
        guiButtons.add(yellow);
        guiButtons.add(green);
        //window makes them appear on the screen.
        window.add(topTitle,BorderLayout.NORTH);
        window.add(guiButtons, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }
    //if & else statments call on source of button thats clicked & paints over preset colors
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==red){
            isRed=true;
            isYellow=false;
            isGreen=false;
        }
        else if(e.getSource()==yellow){
            isRed=false;
            isYellow=true;
            isGreen=false;
        }
        else if(e.getSource()==green){
            isRed=false;
            isYellow=false;
            isGreen=true;
        }
        display.repaint();
    }
    //extention of jpanel with background color white
    class DisplayPanel extends JPanel {
        DisplayPanel(){
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }

        //calls paint & creates Graphics2D object for anti aliasing
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            //int variables for rect width & height

            int rectWidth = 100;
            int rectHeight = 300;
            g2d.setColor(Color.black);
            g2d.fillRect((DISPLAY_WIDTH / 2 - ovalSize / 2)+45,
                    (DISPLAY_HEIGHT / 2 - ovalSize / 2)-25,
                    rectWidth, rectHeight);

            //int variables for stop/red with if/else statment

            int width = 50;
            int height = 50;
            if(isRed) {
                g2d.setColor(new Color(85,142,60));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2 - ovalSize / 2,
                        width, height);
                g2d.setColor(new Color(204,204,0));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2,
                        width, height);
                g2d.setColor(new Color(255,0,0));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT-100,
                        width, height);

            }

            //int variables for slow/yellow color with if/else statment
            else if(isYellow) {
                g2d.setColor(new Color(85,142,60));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2 - ovalSize / 2,
                        width, height);
                g2d.setColor(new Color(255, 255, 0));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2,
                        width, height);
                g2d.setColor(new Color(199, 54, 54));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT - 100,
                        width, height);

            }
            //int variables for go/green color with if/else statment
            else if(isGreen) {
                g2d.setColor(new Color(128,255,0));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2 - ovalSize / 2,
                        width, height);
                g2d.setColor(new Color(204,204,0));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT / 2,
                        width, height);
                g2d.setColor(new Color(199,54,54));
                g2d.fillOval((DISPLAY_WIDTH / 2 - ovalSize / 2)+70,
                        DISPLAY_HEIGHT-100,
                        width, height);
            }
        }
    }
}


