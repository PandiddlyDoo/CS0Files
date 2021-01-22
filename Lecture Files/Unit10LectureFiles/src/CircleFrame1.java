import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CircleFrame1 extends JFrame implements ActionListener, ItemListener {
    JPanel controlPanel, titlePanel;
    JLabel title;
    JButton bigger, smaller;
    JRadioButton red, blue, green;
    ButtonGroup colorGroup;
    Circle circle;

    public static void main(String[] args) {
        CircleFrame1 frame = new CircleFrame1();
        frame.setSize(new Dimension(400, 400));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        setUpTitle();
        setUpControls();
        setUpCircle();
    }

    public void setUpCircle(){
        circle=new Circle(getWidth()/2-125, 0,250, 250);
        add(circle, BorderLayout.CENTER);
    }

    public void setUpTitle(){
        titlePanel=new JPanel(new FlowLayout());
        title=new JLabel("Change the circle!");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    public void setUpControls(){
        controlPanel=new JPanel(new FlowLayout());
        bigger=new JButton("bigger");
        smaller=new JButton("smaller");
        bigger.addActionListener(this);
        smaller.addActionListener(this);

        red=new JRadioButton("red");
        blue=new JRadioButton("blue");
        green=new JRadioButton("green");
        red.addItemListener(this);
        blue.addItemListener(this);
        green.addItemListener(this);

        colorGroup= new ButtonGroup();

        colorGroup.add(red);
        colorGroup.add(blue);
        colorGroup.add(green);

        controlPanel.add(bigger);
        controlPanel.add(smaller);

        controlPanel.add(red);
        controlPanel.add(blue);
        controlPanel.add(green);

        add(controlPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

        if(source==bigger){
            circle.setSize(10);
            circle.repaint();
        }
        if(source==smaller){
            circle.setSize(-10);
            circle.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == red) {
            circle.setCircleColor(Color.red);
            repaint();
        }
        if (e.getSource() == green) {
            circle.setCircleColor(Color.green);
            repaint();
        }
        if (e.getSource() == blue) {
            circle.setCircleColor(Color.blue);
            repaint();
        }
    }
}
