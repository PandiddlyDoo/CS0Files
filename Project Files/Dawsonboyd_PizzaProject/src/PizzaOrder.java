/**Pizza Project
 * @author Dawson Boyd
 * @version Fall2020
 * CSci 1130
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/*10-23-2020
Very messy and unoptimized. I was leaving for a trip and had to complete by Friday. There are lots of changes I would
have made but didn't have the time. I plan to fix the mess in my own time. If I could have the opportunity to resubmit
when I have access to a computer next week that would be appreciated. I believe it still meets all the project requirements
but a lot of changes can be made for clarity
 */

public class PizzaOrder extends JFrame implements ActionListener, ItemListener {
    //declare all components
    JButton submit, clear;
    JTextArea output;
    JRadioButton choice1, choice2, choice3, choice4;
    ButtonGroup group, cgroup;
    JCheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9, check10;
    JPanel radios, button, checkBoxPanel, outputPanel, imgPanel;
    JScrollPane scroll;
    String outputText = "";
    boolean radio1Chosen, radio2Chosen, radio3Chosen, radio4Chosen;
    boolean check1Chosen, check2Chosen, check3Chosen, check4Chosen, check5Chosen, check6Chosen, check7Chosen,
            check8Chosen, check9Chosen, check10Chosen;
    double runningTotal;
    Image img1, img2, img3, img4;

    //Main method calling other methods to save space
    public static void main(String[] args) {
        PizzaOrder frame = new PizzaOrder();
        frame.setSize(new Dimension(800, 600));
        frame.setLayout(new BorderLayout());
        frame.createGUI();
        frame.setVisible(true);
        frame.loadPizza1();
        frame.loadPizza2();
        frame.loadPizza3();
        frame.loadPizza4();
    }

    //createGUI method calling methods similar to Main
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
        //computing the running total and formatting to 2 decimal places
            if (e.getSource() == submit) {
                buildOutputString();
                computeRunningTotal();
                DecimalFormat df = new DecimalFormat("#.00");
                String formatted = df.format(runningTotal);
                output.setText(outputText + "Total: " + formatted);
                outputText = "";
            } else if (e.getSource() == clear) {
                output.setText("");
                resetButton();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //hold the event object in a variable for easy use later
        Object source = e.getSource();

        //Checkboxes
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
            if (source == check4) {
                check4Chosen=false;
            }
            if (source == check5) {
                check5Chosen=false;
            }
            if (source == check6) {
                check6Chosen=false;
            }
            if (source == check7) {
                check7Chosen=false;
            }
            if (source == check8) {
                check8Chosen=false;
            }
            if (source == check9) {
                check9Chosen=false;
            }
            if (source == check10) {
                check10Chosen=false;
            }

            //Radio Buttons
            if (source == choice1) {//check the source and see if it has been selected
                radio1Chosen=false;
            }
            if (source == choice2) {
                radio2Chosen=false;
            }
            if (source == choice3) {
                radio3Chosen=false;
            }
            if (source == choice4) {
                radio4Chosen=false;
            }
            return;//do nothing  a return will terminate the method
        }

        //set up radio events
        Graphics g =imgPanel.getGraphics();

        if (source == choice1) {
            radio1Chosen=true;
            ImageIcon ico=new ImageIcon(img1);
            ico.paintIcon(this, g, 30, 30);
        } else if (source == choice2) {
            radio2Chosen=true;
            ImageIcon ico=new ImageIcon(img2);
            ico.paintIcon(this, g, 30, 30);
        } else if (source == choice3) {
            radio3Chosen=true;
            ImageIcon ico=new ImageIcon(img3);
            ico.paintIcon(this, g, 30, 30);
        } else if (source == choice4) {
        radio4Chosen=true;
            ImageIcon ico=new ImageIcon(img4);
            ico.paintIcon(this, g, 30, 30);
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
        if (source == check4 && check4.isSelected()) {
            check4Chosen=true;
        }
        if (source == check5 && check5.isSelected()) {
            check5Chosen=true;
        }
        if (source == check6 && check6.isSelected()) {
            check6Chosen=true;
        }
        if (source == check7 && check7.isSelected()) {
            check7Chosen=true;
        }
        if (source == check8 && check8.isSelected()) {
            check8Chosen=true;
        }
        if (source == check9 && check9.isSelected()) {
            check9Chosen=true;
        }
        if (source == check10 && check10.isSelected()) {
            check10Chosen=true;
        }
    }

    //GUI METHODS HERE

    //Creating a receipt
    public void buildOutputString(){
        if(radio1Chosen){
            outputText+="Small: 9.99\n";
        }
        if(radio2Chosen){
            outputText+="Medium: 10.99\n";
        }
        if(radio3Chosen){
            outputText+="Large: 12.99\n";
        }
        if(radio4Chosen) {
            outputText += "Jumbo: 14.99\n";
        }
        if(check1Chosen){
            outputText+="Ham: 0.99\n";
        }
        if(check2Chosen){
            outputText+="Salami: 0.99\n";
        }
        if(check3Chosen){
            outputText+="Pepperoni: 0.99\n";
        }
        if(check4Chosen){
            outputText+="Sausage: 0.99\n";
        }
        if(check5Chosen){
            outputText+="Bacon: 0.99\n";
        }
        if(check6Chosen){
            outputText+="Olives: 0.99\n";
        }
        if(check7Chosen){
            outputText+="Mushrooms: 0.99\n";
        }
        if(check8Chosen){
            outputText+="Onions: 0.99\n";
        }
        if(check9Chosen){
            outputText+="Provolone: 0.99\n";
        }
        if(check10Chosen){
            outputText+="Cheddar Cheese: 0.99\n";
        }
    }

    //Calculating the running total of all ingredients chosen.
    //Set to 0 at the beginning to prevent runaway numbers on multiple submissions
    public void computeRunningTotal(){

//        runningTotal = 0;

        if(check1Chosen){
            runningTotal += 0.99;
        }
        if(check2Chosen){
            runningTotal += 0.99;
        }
        if(check3Chosen){
            runningTotal += 0.99;
        }
        if(check4Chosen){
            runningTotal += 0.99;
        }
        if(check5Chosen){
            runningTotal += 0.99;
        }
        if(check6Chosen){
            runningTotal += 0.99;
        }
        if(check7Chosen){
            runningTotal += 0.99;
        }
        if(check8Chosen){
            runningTotal += 0.99;
        }
        if(check9Chosen){
            runningTotal += 0.99;
        }
        if(check10Chosen){
            runningTotal += 0.99;
        }
        if(radio1Chosen){
            runningTotal += 9.99;
        }
        if(radio2Chosen){
            runningTotal += 10.99;
        }
        if(radio3Chosen){
            runningTotal += 12.99;
        }
        if(radio4Chosen) {
            runningTotal += 14.99;
        }


    }

    //create and add all checkboxes
    public void setUpChecks() {
        checkBoxPanel = new JPanel(new GridLayout(10, 1));
        check1 = new JCheckBox("Ham");
        check2 = new JCheckBox("Salami");
        check3 = new JCheckBox("Pepperoni");
        check4 = new JCheckBox("Sausage");
        check5 = new JCheckBox("Bacon");
        check6 = new JCheckBox("Olives");
        check7 = new JCheckBox("Mushrooms");
        check8 = new JCheckBox("Onions");
        check9 = new JCheckBox("Provolone");
        check10 = new JCheckBox("Cheddar Cheese");

        checkBoxPanel.add(check1);
        checkBoxPanel.add(check2);
        checkBoxPanel.add(check3);
        checkBoxPanel.add(check4);
        checkBoxPanel.add(check5);
        checkBoxPanel.add(check6);
        checkBoxPanel.add(check7);
        checkBoxPanel.add(check8);
        checkBoxPanel.add(check9);
        checkBoxPanel.add(check10);

        getContentPane().add(checkBoxPanel, BorderLayout.WEST);
    }
    //register all checkboxes
    public void registerChecks() {
        check1.addItemListener(this);
        check2.addItemListener(this);
        check3.addItemListener(this);
        check4.addItemListener(this);
        check5.addItemListener(this);
        check6.addItemListener(this);
        check7.addItemListener(this);
        check8.addItemListener(this);
        check9.addItemListener(this);
        check10.addItemListener(this);
    }

    //create and all all radio buttons
    //radio buttons are added to a button group so that only one can be selected at a time
    public void setUpRadios() {
        //create button group
        group = new ButtonGroup();

        //create radio buttons
        choice1 = new JRadioButton("Small 10\"");
        choice2 = new JRadioButton("Medium 12\"");
        choice3 = new JRadioButton("Large 14\"");
        choice4 = new JRadioButton("Jumbo 16\"");

        //create the panel and set layout
        radios = new JPanel();
        radios.setLayout(new FlowLayout());

        //add buttons to the group
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);
        group.add(choice4);

        //add buttons to the panel
        radios.add(choice1);
        radios.add(choice2);
        radios.add(choice3);
        radios.add(choice4);

        //add the panel to the north of the applet
        getContentPane().add(radios, BorderLayout.NORTH);
    }
    //register the radio buttons to the listener
    public void registerRadios() {
        choice1.addItemListener(this);
        choice2.addItemListener(this);
        choice3.addItemListener(this);
        choice4.addItemListener(this);
    }

    //create and add the output text area and image panel
    public void setUpOutput() {
        //instantiate components
        outputPanel = new JPanel();
        imgPanel = new JPanel();
        output = new JTextArea(30,12);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.append("Small: 9.99\n Medium: 10.99\n Large: 12.99\n Jumbo 14.99\n All Toppings 99 cents");

        scroll = new JScrollPane(output);//output JTextArea must get added to the JScrollPane

        //setLayout
        outputPanel.setLayout(new FlowLayout());
        imgPanel.setLayout(new FlowLayout());
        imgPanel.setBackground(Color.WHITE);

        //add components
        outputPanel.add(scroll);
        getContentPane().add(outputPanel, BorderLayout.EAST);
        getContentPane().add(imgPanel, BorderLayout.CENTER);
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

    //Loading all images for pizza sizes
    public void loadPizza1(){
        String path = "images/pizza1.png";
        File file = new File(path);
        try {
            img1 = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadPizza2(){
        String path = "images/pizza2.png";
        File file = new File(path);
        try {
            img2 = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadPizza3(){
        String path = "images/pizza3.png";
        File file = new File(path);
        try {
            img3 = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadPizza4(){
        String path = "images/pizza4.png";
        File file = new File(path);
        try {
            img4 = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Found a way to clear the buttons with the clear button
    //Messy but it gets the job done
    public void resetButton(){
        cgroup = new ButtonGroup();

        cgroup.add(choice1);
        cgroup.add(choice2);
        cgroup.add(choice3);
        cgroup.add(choice4);

        cgroup.add(check1);
        cgroup.add(check2);
        cgroup.add(check3);
        cgroup.add(check4);
        cgroup.add(check5);
        cgroup.add(check6);
        cgroup.add(check7);
        cgroup.add(check8);
        cgroup.add(check9);
        cgroup.add(check10);

        cgroup.clearSelection();

        group.remove(check1);
        group.remove(check2);
        group.remove(check3);
        group.remove(check4);
        group.remove(check5);
        group.remove(check6);
        group.remove(check7);
        group.remove(check8);
        group.remove(check9);
        group.remove(check10);

        output.append("Small: 9.99\n Medium: 10.99\n Large: 12.99\n Jumbo 14.99\n All Toppings 99 cents");
        imgPanel.removeAll();
        imgPanel.repaint();


    }
}
