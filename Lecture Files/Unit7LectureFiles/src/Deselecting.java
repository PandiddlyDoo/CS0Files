import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Deselecting extends JFrame implements ItemListener {
    JCheckBox ch1, ch2;
    JLabel output;
    int totalChecks;
    public static void main(String[] args) {
        Deselecting frame = new Deselecting();
        frame.setSize(new Dimension(400, 100));
        frame.setLayout(new FlowLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        ch1=new JCheckBox("box 1");
        ch2=new JCheckBox("box 2");
        output=new JLabel("empty");

        window.add(ch1);
        window.add(ch2);
        window.add(output);
        ch1.addItemListener(this);
        ch2.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==ch1&&ch1.isSelected()){
            totalChecks++;
            output.setText(""+totalChecks+"Total Cost: "+totalChecks*2.99);
        }
        if(e.getSource()==ch2&&ch2.isSelected()){
            totalChecks++;
            output.setText(""+totalChecks+"Total Cost: "+totalChecks*2.99);
        }
        if(e.getStateChange()==ItemEvent.DESELECTED) {
            if ((e.getSource() == ch1)||(e.getSource() == ch2 )) {
                totalChecks--;
                output.setText(""+totalChecks+"Total Cost: "+totalChecks*2.99);
            }
        }
    }
}
