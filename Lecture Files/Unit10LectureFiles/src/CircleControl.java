import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Charlie Gorrill on 3/23/2016.
 */
public class CircleControl extends JPanel implements ActionListener, ItemListener {
    Circle circle;

    JPanel controlPanel;

    JButton bigger, smaller;
    JRadioButton red, blue, green;

    ButtonGroup colorGroup;

    public CircleControl(Circle c){
        circle=c;
        setUpControls();
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
            circle.repaint();
        }
        if (e.getSource() == green) {
            circle.setCircleColor(Color.green);
            circle.repaint();
        }
        if (e.getSource() == blue) {
            circle.setCircleColor(Color.blue);
            circle.repaint();
        }
    }
}
