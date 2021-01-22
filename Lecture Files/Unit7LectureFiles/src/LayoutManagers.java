import javax.swing.*;
import java.awt.*;

public class LayoutManagers extends JFrame {
    JTextField fNameField, lNameField,
            ageField, heightField, weightField;
    JLabel fNameLabel, lNameLabel,
            ageLabel, heightLabel, weightLabel,
            titleLabel;

    JPanel fieldPanel, labelPanel, inputsPanel, titlePanel,
            outputPanel, submitPanel;

    JTextArea output;

    JButton submit;

    BoxLayout fieldBox, labelBox;
    public static void main(String[] args) {
        LayoutManagers frame = new LayoutManagers();
        frame.setSize(new Dimension(600, 300));

        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inputsPanel = new JPanel(new FlowLayout());
        setUpLables();
        setUpFields();
        setUpTitle();
        setUpOutput();
        setUpSubmit();

    }


    public void setUpSubmit(){
        submitPanel=new JPanel(new FlowLayout());
        submit=new JButton("submit");
        submitPanel.add(submit);
        getContentPane().add(submitPanel, BorderLayout.SOUTH);
    }

    public void setUpOutput() {
        output = new JTextArea(12, 25);
        outputPanel=new JPanel(new FlowLayout());
        outputPanel.add(output);
        getContentPane().add(outputPanel);
    }

    public void setUpTitle() {
        titlePanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel("Personal Data");
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
    }

    public void setUpLables() {

        labelPanel = new JPanel();
        labelBox = new BoxLayout(labelPanel, BoxLayout.Y_AXIS);
        labelPanel.setLayout(labelBox);

        lNameLabel = new JLabel("Last Name");
        fNameLabel = new JLabel("First Name");
        ageLabel = new JLabel("Age");
        heightLabel = new JLabel("Height");
        weightLabel = new JLabel("Weight");

        labelPanel.add(fNameLabel);
        labelPanel.add(lNameLabel);
        labelPanel.add(ageLabel);
        labelPanel.add(heightLabel);
        labelPanel.add(weightLabel);

        inputsPanel.add(labelPanel);

    }

    public void setUpFields() {
        fieldPanel = new JPanel();
        fieldBox = new BoxLayout(fieldPanel, BoxLayout.Y_AXIS);
        fieldPanel.setLayout(fieldBox);

        lNameField = new JTextField(12);
        fNameField = new JTextField(12);
        ageField = new JTextField(12);
        heightField = new JTextField(12);
        weightField = new JTextField(12);

        fieldPanel.add(fNameField);
        fieldPanel.add(lNameField);
        fieldPanel.add(ageField);
        fieldPanel.add(heightField);
        fieldPanel.add(weightField);

        inputsPanel.add(fieldPanel);
        getContentPane().add(inputsPanel, BorderLayout.WEST);
    }
}
