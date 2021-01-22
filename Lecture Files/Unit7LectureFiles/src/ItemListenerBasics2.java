import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerBasics2 extends JFrame implements ItemListener {
    JCheckBox ch1, ch2, ch3;
    JPanel checkBoxes;
    JLabel text;
    String outputText="";
    public static void main(String[] args) {
        ItemListenerBasics2 frame = new ItemListenerBasics2();
        frame.setSize(new Dimension(400, 100));
        frame.setLayout(new FlowLayout());

        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        setUpButtons();
        setUpText();
        registerBoxes();
    }

    public void setUpText() {
        text = new JLabel("Text will appear here: ");
        add(text);
    }

    public void setUpButtons() {
        checkBoxes = new JPanel();
        checkBoxes.setLayout(new FlowLayout());

        ch1 = new JCheckBox("one");
        ch2 = new JCheckBox("two");
        ch3 = new JCheckBox("three");

        checkBoxes.add(ch1);
        checkBoxes.add(ch2);
        checkBoxes.add(ch3);

        add(checkBoxes);
    }

    public void registerBoxes(){
        ch1.addItemListener(this);
        ch2.addItemListener(this);
        ch3.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (ch1.isSelected()) {//check the source and see if it has been selected
            outputText += "Check 1 has been checked ";
        }
        if (ch2.isSelected()) {
            outputText += "Check 2 has been checked ";
        }
        if (ch3.isSelected()) {
            outputText += "Check 3 has been checked ";
        }
        text.setText(outputText);
        outputText="";
    }
}
