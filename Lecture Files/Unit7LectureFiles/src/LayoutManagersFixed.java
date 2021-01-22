import javax.swing.*;
import java.awt.*;

public class LayoutManagersFixed extends JFrame {

    JTextField fNameField, lNameField,
            ageField, heightField, weightField;
    JLabel fNameLabel, lNameLabel,
            ageLabel, heightLabel, weightLabel,
            titleLabel;

    JPanel inputsPanel, titlePanel,outputPanel, submitPanel;

    JTextArea output;

    JButton submit;

    GridLayout inputs;
    public static void main(String[] args) {
        LayoutManagersFixed frame = new LayoutManagersFixed();
        frame.setSize(new Dimension(600, 300));
        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inputsPanel = new JPanel(new FlowLayout());
        setUpLabelsAndFileds();
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

    public void setUpLabelsAndFileds(){
        submitPanel=new JPanel();
        inputs=new GridLayout(5,2);
        submitPanel.setLayout(inputs);

        lNameLabel = new JLabel("Last Name");
        lNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fNameLabel = new JLabel("First Name");
        fNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageLabel = new JLabel("Age");
        ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        heightLabel = new JLabel("Height");
        heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weightLabel = new JLabel("Weight");
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);

        lNameField = new JTextField(12);
        fNameField = new JTextField(12);
        ageField = new JTextField(12);
        heightField = new JTextField(12);
        weightField = new JTextField(12);

        submitPanel.add(fNameLabel);
        submitPanel.add(fNameField);

        submitPanel.add(lNameLabel);
        submitPanel.add(lNameField);

        submitPanel.add(ageLabel);
        submitPanel.add(ageField);

        submitPanel.add(heightLabel);
        submitPanel.add(heightField);

        submitPanel.add(weightLabel);
        submitPanel.add(weightField);



        add(submitPanel, BorderLayout.WEST);
    }
}
