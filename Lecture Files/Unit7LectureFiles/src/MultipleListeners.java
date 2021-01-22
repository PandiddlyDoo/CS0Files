import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MultipleListeners extends JFrame implements ActionListener, ItemListener {
    //declare all components
    JButton submit, clear;
    JTextArea output;
    JRadioButton choice1, choice2, choice3;
    ButtonGroup group;
    JCheckBox check1, check2, check3;
    JPanel radios, button, checkBoxPanel, outputpanel;
    JScrollPane scroll;
    String outputText = "";
    boolean radio1Chosen, radio2Chosen, radio3Chosen;
    boolean check1Chosen, check2Chosen, check3Chosen;

    public static void main(String[] args) {
        MultipleListeners frame = new MultipleListeners();
        frame.setSize(new Dimension(400, 200));
        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //call methods to create and add components
        setUpRadios();
        setUpChecks();
        setUpButtons();
        setUpOutput();

        //call methods to register components to listeners
        registerChecks();
        registerRadios();
        registerButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            buildOutputString();
            output.setText(outputText);
            outputText="";
        }
        else if(e.getSource()==clear){
            output.setText("");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //hold the event object in a variable for easy use later
        Object source = e.getSource();

        //if one of the checkboxes is desleected, do nothing
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            if (source == check1) {//check the source and see if it has been selected
                check1Chosen=false;
            }
            if (source == check2) {
                check2Chosen=false;
            }
            if (source == check3) {
                check3Chosen=false;
            }
            if (source == choice1) {//check the source and see if it has been selected
                radio1Chosen=false;
            }
            if (source == choice2) {
                radio2Chosen=false;
            }
            if (source == choice3) {
                radio3Chosen=false;
            }
            return;//do nothing  a return will terminate the method
        }

        //set up radio events
        if (source == choice1) {
            radio1Chosen=true;//concatenate the current text to existing text
        } else if (source == choice2) {
            radio2Chosen=true;//\n is a new line character.  It will make a new line
        } else if (source == choice3) {
            radio3Chosen=true;
        }

        //set up check box events
        if (source == check1 && check1.isSelected()) {//check the source and see if it has been selected
            check1Chosen=true;
        }
        if (source == check2 && check2.isSelected()) {
            check2Chosen=true;
        }
        if (source == check3 && check3.isSelected()) {
            check3Chosen=true;
        }
    }

    //GUI METHODS HERE
    public void buildOutputString(){
        if(check1Chosen){
            outputText+="Check 1 chosen.\n";
        }
        if(check2Chosen){
            outputText+="Check 2 chosen.\n";
        }
        if(check3Chosen){
            outputText+="Check 3 chosen.\n";
        }
        if(radio1Chosen){
            outputText+="Radio 1 chosen.\n";
        }
        if(radio2Chosen){
            outputText+="Radio 2 chosen.\n";
        }
        if(radio3Chosen){
            outputText+="Radio 3 chosen.\n";
        }
    }

    //create and add all checkboxes
    public void setUpChecks() {
        checkBoxPanel = new JPanel(new GridLayout(3, 1));
        check1 = new JCheckBox("one");
        check2 = new JCheckBox("two");
        check3 = new JCheckBox("three");

        checkBoxPanel.add(check1);
        checkBoxPanel.add(check2);
        checkBoxPanel.add(check3);

        getContentPane().add(checkBoxPanel, BorderLayout.WEST);
    }
    //register all checkboxes
    public void registerChecks() {
        check1.addItemListener(this);
        check2.addItemListener(this);
        check3.addItemListener(this);
    }

    //create and all all radio buttons
    //radio buttons are added to a button group so that only one can be selected at a time
    public void setUpRadios() {
        //create button group
        group = new ButtonGroup();

        //create radio buttons
        choice1 = new JRadioButton("Choice1");
        choice2 = new JRadioButton("Choice2");
        choice3 = new JRadioButton("Choice3");

        //create the panel and set layout
        radios = new JPanel();
        radios.setLayout(new FlowLayout());

        //add buttons to the group
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);

        //add buttons to the panel
        radios.add(choice1);
        radios.add(choice2);
        radios.add(choice3);

        //add the panel to the north of the applet
        getContentPane().add(radios, BorderLayout.NORTH);
    }
    //register the radio buttons to the listener
    public void registerRadios() {
        choice1.addItemListener(this);
        choice2.addItemListener(this);
        choice3.addItemListener(this);
    }

    //create and add the output text area
    public void setUpOutput() {
        //instantiate components
        outputpanel = new JPanel();
        output = new JTextArea(7,25);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);

        scroll = new JScrollPane(output);//output JTextArea must get added to the JScrollPane

        //setLayout
        outputpanel.setLayout(new FlowLayout());

        //add components
        outputpanel.add(scroll);
        getContentPane().add(outputpanel, BorderLayout.CENTER);
    }

    //create and add the buttons
    public void setUpButtons() {
        //crate panel to hold buttons and set layout to flow
        button = new JPanel();
        button.setLayout(new FlowLayout());

        //create the buttons
        submit = new JButton("submit");
        clear = new JButton("clear");

        //add the buttons
        button.add(submit);
        button.add(clear);

        //add the panel
        getContentPane().add(button, BorderLayout.SOUTH);
    }
    //register the buttons to the listener
    public void registerButtons(){
        submit.addActionListener(this);
        clear.addActionListener(this);
    }
}
