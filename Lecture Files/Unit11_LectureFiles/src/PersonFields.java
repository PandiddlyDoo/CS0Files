import javax.swing.*;
import java.awt.*;

public class PersonFields extends JPanel {
    JLabel fNameLabel, lNameLabel, ageLabel;
    JTextField fNameField, lNameField, ageField;

    public PersonFields(){
        setLayout(new GridLayout(3,2));
        setUpFields();
        setUpLabels();
        addComponents();
    }

    public void setUpLabels(){
        fNameLabel=new JLabel("First Name: ", JLabel.RIGHT);
        lNameLabel=new JLabel("LastName: ", JLabel.RIGHT);
        ageLabel=new JLabel("Age: ", JLabel.RIGHT);
    }

    public void setUpFields(){
        fNameField=new JTextField(15);
        lNameField=new JTextField(15);
        ageField=new JTextField(15);
    }

    public void clearAll(){
        fNameField.setText("");
        lNameField.setText("");
        ageField.setText("");
    }

    public void disableFields(){
        fNameField.setEnabled(false);
        lNameField.setEnabled(false);
        ageField.setEnabled(false);
    }

    public void enableFields(){
        fNameField.setEnabled(true);
        lNameField.setEnabled(true);
        ageField.setEnabled(true);
    }

    public void addComponents(){
        add(fNameLabel);
        add(fNameField);
        add(lNameLabel);
        add(lNameField);
        add(ageLabel);
        add(ageField);
    }

    public JTextField getfNameField() {
        return fNameField;
    }

    public JTextField getlNameField() {
        return lNameField;
    }

    public JTextField getAgeField() {
        return ageField;
    }
}
