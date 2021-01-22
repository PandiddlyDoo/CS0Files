import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerBasics extends JFrame implements ItemListener {
    ButtonGroup group;
    JRadioButton red, green, blue, r4;
    public static void main(String[] args) {
        ItemListenerBasics frame = new ItemListenerBasics();
        frame.setSize(new Dimension(400, 100));
        frame.setLayout(new FlowLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        setUpRadios();

    }

    private void setUpRadios() {
        group=new ButtonGroup();

        red =new JRadioButton("red");
        red.setFocusPainted(false);
        green =new JRadioButton("green");
        green.setFocusPainted(false);
        blue =new JRadioButton("blue");
        blue.setFocusPainted(false);


        group.add(red);
        group.add(green);
        group.add(blue);

        add(red);
        add(green);
        add(blue);

        red.addItemListener(this);
        green.addItemListener(this);
        blue.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==red){
            getContentPane().setBackground(Color.RED);
            red.setBackground(Color.red);
            green.setBackground(Color.red);
            blue.setBackground(Color.red);
        }
        if(e.getSource()==green){
            getContentPane().setBackground(Color.GREEN);
            red.setBackground(Color.green);
            green.setBackground(Color.green);
            blue.setBackground(Color.green);
        }
        if(e.getSource()==blue){
            getContentPane().setBackground(Color.BLUE);
            red.setBackground(Color.blue);
            green.setBackground(Color.blue);
            blue.setBackground(Color.blue);
        }
    }
}
