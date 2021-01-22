import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class FlashingLights extends JFrame implements ActionListener, ChangeListener {

    private JPanel drawPanel;
    private Timer timer;
    private JSlider timeGapSlider;
    private JTextField gapField;
    int timeGap;
    SecureRandom rand;

    public static void main(String[] args) {
        FlashingLights frame = new FlashingLights();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(400, 400));
        drawPanel.setBackground(Color.WHITE);

        timeGapSlider=new JSlider(JSlider.HORIZONTAL, 200, 2000, 1000);
        gapField=new JTextField(3);
        gapField.setText(""+timeGapSlider.getValue());

        timer=new javax.swing.Timer(1000, this);
        rand=new SecureRandom();
        //add components
        window.add(drawPanel);
        window.add(timeGapSlider);
        window.add(gapField);
        //register components
        timeGapSlider.addChangeListener(this);

        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(makeRandomColor());
        g.fillRect(0,0,drawPanel.getWidth(), drawPanel.getHeight());
        g.setColor(makeRandomColor());
        draw4Ovals(g,0,0);
        g.setColor(makeRandomColor());
        draw4Ovals(g, 200, 0);
        g.setColor(makeRandomColor());
        draw4Ovals(g, 0, 200);
        g.setColor(makeRandomColor());
        draw4Ovals(g, 200 , 200);
    }

    public void draw4Ovals(Graphics g, int xOffset, int yOffset){
        g.fillOval(10+xOffset,10+yOffset,80,80);
        g.fillOval(10+xOffset,100+yOffset,80,80);
        g.fillOval(100+xOffset,10+yOffset,80,80);
        g.fillOval(100+xOffset,100+yOffset,80,80);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        /*valueOf is a static method from the String class.  It will
        look at a String and if it has a numeric value, it will return
        the int value of the number.
        */
        gapField.setText(String.valueOf(timeGapSlider.getValue()));
        timeGap=timeGapSlider.getValue();
        timer.setDelay(timeGap);
    }

    public Color makeRandomColor(){
        int r=rand.nextInt(256);
        int g=rand.nextInt(256);
        int b=rand.nextInt(256);
        return new Color(r,g,b);
    }
}
