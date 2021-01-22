/**Smiley2 Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SmileControl extends JPanel implements ActionListener, ItemListener {
    Smiley circle;

    JPanel controlPanel;

    JButton bigger, smaller, randomEyes;
    JRadioButton red, blue, green;

    ButtonGroup colorGroup;

    JComboBox expressionBox;
    Boolean isSmiling;
    String comboString=("Smile");

    public SmileControl(Smiley c){
        circle=c;
        setUpControls();
    }

    public void setUpControls(){
        controlPanel=new JPanel(new FlowLayout());
        bigger=new JButton("bigger");
        smaller=new JButton("smaller");
        bigger.addActionListener(this);
        smaller.addActionListener(this);

        randomEyes=new JButton("RandomEyes");
        randomEyes.addActionListener(this);

        red=new JRadioButton("red");
        blue=new JRadioButton("blue");
        green=new JRadioButton("green");
        red.addItemListener(this);
        blue.addItemListener(this);
        green.addItemListener(this);

        expressionBox=new JComboBox();
        expressionBox.addItem("Smile");
        expressionBox.addItem("Frown");
        expressionBox.addItemListener(this);

        colorGroup= new ButtonGroup();

        colorGroup.add(red);
        colorGroup.add(blue);
        colorGroup.add(green);

        controlPanel.add(bigger);
        controlPanel.add(smaller);
        controlPanel.add(expressionBox);

        controlPanel.add(randomEyes);

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
        if (e.getSource() == randomEyes) {
            Color eyesColor=makeRandomColor();
            circle.setEyesColor(eyesColor);
            circle.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == red) {
            circle.setCircleColor(Color.red);
        }
        if (e.getSource() == green) {
            circle.setCircleColor(Color.green);
        }
        if (e.getSource() == blue) {
            circle.setCircleColor(Color.blue);
        }

        comboString = expressionBox.getSelectedItem().toString();
        if (comboString.equalsIgnoreCase("Smile")){
            isSmiling=true;
        }else if (comboString.equalsIgnoreCase("Frown")){
            isSmiling=false;
        }
        circle.setSmile(isSmiling);
        circle.repaint();
    }

    public Color makeRandomColor() {
        int r = (int) (Math.random() * 256);
        int gr = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        Color color = new Color(r, gr, b);
        return color;
    }
}
