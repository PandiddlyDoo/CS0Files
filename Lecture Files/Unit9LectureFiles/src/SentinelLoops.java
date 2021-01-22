import javax.swing.*;
import java.awt.*;

public class SentinelLoops extends JFrame {

    boolean loopFlag;
    JLabel message;
    int count;
    JTextArea output;
    JPanel outputPanel;

    JList foodList;
    DefaultListModel model;

    public static void main(String[] args) {
        SentinelLoops frame = new SentinelLoops();
        frame.setSize(new Dimension(400, 200));
        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.executeMethods();
        frame.setVisible(true);
    }

    public void executeMethods(){
        example1();
       // example2();
    }

    public void example1() {
        loopFlag = true;
        while (loopFlag) {
            int choice = JOptionPane.showConfirmDialog(this, "Hello! May I greet you again?", "Annoying greeting.",
                    JOptionPane.YES_NO_OPTION);
            count++;
            if (choice == 1) {
                loopFlag = false;
            }
        }
        message.setText("I can't believe that you acutually clicked yes " + count + " times!!");
    }

    //uses a do/while loop controlled by a sentinel value
    public void example2() {

        loopFlag = false;
        String outputText = "";
        do {
            model.addElement(JOptionPane.showInputDialog("What food do you like?"));
            int choice = JOptionPane.showConfirmDialog(this, "Would you like to enter another food?", "Annoying question.",
                    JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                loopFlag = true;
            } else if (choice == 1) {
                loopFlag = false;
            }

        } while (loopFlag);


        for (int i = 0; i < model.getSize(); i++) {
            output.append((String) model.get(i) + "\n");
        }
    }


    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUpList();
        setUpOutput();
    }

    public void setUpOutput() {
        output = new JTextArea(8, 25);
        message = new JLabel("");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(message, BorderLayout.SOUTH);
        outputPanel = new JPanel(new FlowLayout());
        outputPanel.add(output);
        add(outputPanel, BorderLayout.CENTER);
    }

    public void setUpList() {
        model = new DefaultListModel();
        foodList = new JList(model);
        add(foodList);
    }
}
