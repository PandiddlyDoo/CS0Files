import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SliderPractice extends JFrame implements ActionListener, ChangeListener {

    private JPanel drawPanel;
    private JButton draw;
    private JLabel heightLabel, widthLabel;
    private JSlider widthSlider, heightSlider;
    private int height, width;


    public static void main(String[] args) {
        SliderPractice frame = new SliderPractice();
        frame.setSize(new Dimension(340, 430));
        frame.createGUI();
        frame.height=0;
        frame.width=0;
        frame.initializeVariables();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(300, 300));
        drawPanel.setBackground(Color.WHITE);

        draw = new JButton("draw");

        Dimension panelSize=drawPanel.getPreferredSize();

        heightSlider=new JSlider(50, (int)panelSize.getWidth()-15);
        widthSlider=new JSlider(50, (int)panelSize.getHeight()-15);

        heightLabel=new JLabel("adjust height");
        widthLabel=new JLabel("adjust width");
        //add components
        window.add(drawPanel);
        window.add(heightLabel);
        window.add(heightSlider);
        window.add(widthLabel);
        window.add(widthSlider);
        window.add(draw);

        //register components
        draw.addActionListener(this);
        heightSlider.addChangeListener(this);
        widthSlider.addChangeListener(this);



    }


    public void initializeVariables(){

        width=(int)(drawPanel.getPreferredSize().getWidth()/2);//half width of panel
        height=(int)(drawPanel.getPreferredSize().getHeight()/2);//half height of panel
        System.out.printf("(%d, %d)\n", width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = drawPanel.getGraphics();
        int panelWidth=(int)drawPanel.getPreferredSize().getWidth();
        int panelHeight=(int)drawPanel.getPreferredSize().getHeight();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,panelWidth, panelHeight);
        g.setColor(Color.BLACK);
        g.drawRect(panelWidth/2 - width/2, panelHeight/2  - height/2, width, height);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        height=heightSlider.getValue();
        width=widthSlider.getValue();
    }
}
