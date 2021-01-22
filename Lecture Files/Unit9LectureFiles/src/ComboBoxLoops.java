import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxLoops extends JFrame implements ItemListener {
    private static final  int NUM_ITERATIONS = 10;
    JComboBox choiceBox;
    private int choice;
    JTextArea output;
    JPanel choicePanel, outputPanel, guiHolderPanel;

    public static void main(String[] args) {
        ComboBoxLoops frame = new ComboBoxLoops();
        frame.setSize(new Dimension(400, 250));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUpCombo();
        setUpOutput();
        setUpGUI();
    }

    public void setUpGUI(){
        guiHolderPanel=new JPanel(new BorderLayout());
        guiHolderPanel.add(outputPanel, BorderLayout.CENTER);
        guiHolderPanel.add(choicePanel, BorderLayout.SOUTH);

        add(guiHolderPanel);
    }

    public void setUpOutput(){
        outputPanel=new JPanel(new FlowLayout());
        output=new JTextArea(10,25);
        outputPanel.add(output);
    }

    public void setUpCombo() {
        choicePanel=new JPanel(new FlowLayout());
        choiceBox = new JComboBox();

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            choiceBox.addItem(String.valueOf(i + 1));
        }
        choiceBox.addItemListener(this);
        choicePanel.add(choiceBox);
    }

    public void itemStateChanged(ItemEvent e) {
        output.setText("");
        if (e.getStateChange() == ItemEvent.SELECTED) {
            choice = Integer.parseInt((String) choiceBox.getSelectedItem());
        }
        for(int i=0; i<choice; i++){
            output.append(""+(i+1)+"\n");
        }
    }
}
