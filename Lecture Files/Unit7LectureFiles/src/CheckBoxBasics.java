import javax.swing.*;
import java.awt.*;

public class CheckBoxBasics extends JFrame {
    JCheckBox ch1, ch2, ch3, ch4;

    public static void main(String[] args) {
        CheckBoxBasics frame = new CheckBoxBasics();
        frame.setSize(new Dimension(400, 100));
        frame.setLayout(new FlowLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();


        ch1=new JCheckBox("Check 1");
        ch2=new JCheckBox("Check 2");
        ch3=new JCheckBox("Check 3");
        ch4=new JCheckBox("Check 4");

        ch1.setFocusPainted(false);//this will prevent a border from being drawn around the component when checked

        window.add(ch1);
        window.add(ch2);
        window.add(ch3);
        window.add(ch4);
    }
}
