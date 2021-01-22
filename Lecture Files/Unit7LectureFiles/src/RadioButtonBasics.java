import javax.swing.*;
import java.awt.*;

public class RadioButtonBasics extends JFrame {

    ButtonGroup group;
    JRadioButton r1, r2, r3, r4;

    public static void main(String[] args) {
        RadioButtonBasics frame = new RadioButtonBasics();
        frame.setSize(new Dimension(400, 100));
        frame.setLayout(new FlowLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        group=new ButtonGroup();

        r1=new JRadioButton("Radio 1");
        r1.setFocusPainted(false);
        r2=new JRadioButton("Radio 2");
        r2.setFocusPainted(false);
        r3=new JRadioButton("Radio 3");
        r3.setFocusPainted(false);
        r4=new JRadioButton("Radio 4");
        r4.setFocusPainted(false);

        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        window.add(r1);
        window.add(r2);
        window.add(r3);
        window.add(r4);

    }
}
