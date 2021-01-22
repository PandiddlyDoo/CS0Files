import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParallelArrays extends JFrame implements ActionListener {
    private final int FRAME_WIDTH=800, FRAME_HEIGHT=500;
    final int NUM_PEOPLE = 4;
    //this is the data that I will read in from the fields
    String[] fNames, lNames;
    int[] ages;

    // I will use arrays to contain my labels and PersonFields
    JLabel[] labels;
    PersonFields[] fields;

    //just some buttons
    JButton submit, clear, outputButton;

    JTextArea output;
    JScrollPane scroll;

    JPanel inputs, controls;

    public static void main(String[] args) {
        ParallelArrays frame = new ParallelArrays();
        frame.setSize(new Dimension(frame.FRAME_WIDTH, frame.FRAME_HEIGHT));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        setLayout(new BorderLayout());

        //create arrays to hold data from fields
        fNames = new String[NUM_PEOPLE];
        lNames = new String[NUM_PEOPLE];
        ages = new int[NUM_PEOPLE];

        //set it all up!
        setUpInputs();
        setUpButtons();
        setUpOutput();

    }


    public void setUpInputs() {
        //set box layout
        inputs = new JPanel();
        BoxLayout box = new BoxLayout(inputs, BoxLayout.Y_AXIS);
        inputs.setLayout(box);

        //set up labels above fields
        setUpLabels();

        //fields is an array of type PersonFields.  It will hold all of the input fields
        fields = new PersonFields[NUM_PEOPLE];

        //loop over length of fields array
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new PersonFields();//add PersonFields objects to the array
        }

        //this loop will add the labels and field sets to the inputs JPanel
        //loop over the longth of the fields array since it is the same length as labels
        for (int i = 0; i < fields.length; i++) {
            //these are added in parallel.
            //That means that I am adding from the same index from each array at the same time
            inputs.add(labels[i]);
            inputs.add(fields[i]);
        }

        //add inputs to the west of the applet.
        add(inputs, BorderLayout.WEST);
    }

    public void setUpLabels() {
        //instantiate labels array
        labels = new JLabel[NUM_PEOPLE];
        //loop over length of array
        for (int i = 0; i < labels.length; i++) {//add each label to a new index of the array
            labels[i]=new JLabel("Person " + (i+1) + ":");
        }
    }

    public void setUpButtons() {
        //nothing new and fancy here. Just making buttons that work properly.
        controls = new JPanel(new FlowLayout());

        submit = new JButton("submit");
        submit.addActionListener(this);

        clear = new JButton("clear");
        clear.addActionListener(this);

        outputButton = new JButton("to output");
        outputButton.addActionListener(this);

        controls.add(submit);
        controls.add(outputButton);
        controls.add(clear);

        add(controls, BorderLayout.SOUTH);
    }

    public void setUpOutput() {
        //nothing exciting here
        // just creating and setting up a ScrollPane with TextArea
        output = new JTextArea(12, 25);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);

        scroll = new JScrollPane(output);

        add(scroll, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //hold the event source in an Object variable for ease of use later.
        Object button = e.getSource();

        if (button == clear) {
            //loop over the length of the fields array
            for(int i=0; i<fields.length; i++){
                //get each PersonField object and call the clearAll() method on it.
                //fields[i] will get the i element from the fields array
                //if the i is 0 then it gets the first element out of the array and etc. . .
                //since there is a PersonFields object coming out of that array, I can call clearAll() to it
                fields[i].clearAll();
            }
            //clear the TextArea
            output.setText("");
            //make the textFields editable again
            enableInputs();
        }
        if (button == submit) {
            //see the method below
            getTextFromFields();
            //this will make it so that you cannot edit the TextFields
            disableInputs();
        }
        if (button == outputButton) {
            //see the method below
            textToOutput();
        }
    }


    public void getTextFromFields() {
        //loop over the length of the fNames array.  All of the arrays are the same length.
        for (int i = 0; i < fNames.length; i++) {
            //use the arrays in parallel
            //fnames at the i index will get the text from the field at the i index of fields array
            //the same thing happens for lnames and ages
            fNames[i] = fields[i].getfNameField().getText();
            lNames[i] = fields[i].getlNameField().getText();
            ages[i] = Integer.parseInt(fields[i].getAgeField().getText());//remember to parse the ints for ages
        }
    }

    public void textToOutput() {
        //loop over the length of the fNames array
        for (int i = 0; i < fNames.length; i++) {
            //append the text to output
            //I have used the fnames lnames and ages in parallel
            //in other words, I am taking elements from those arrays from the same indices.
            output.append("First Name: " + fNames[i] + " Last Name: " + lNames[i] + " Age: " + ages[i]+"\n");
        }
    }

    public void disableInputs(){
        //loop over the length of the fields array
        for(int i=0; i<fields.length; i++){
            fields[i].disableFields();//call disableFields on each PersonFields object in the array
        }
    }

    public void enableInputs(){
        //loop over the length of the fields array
        for(int i=0; i<fields.length; i++){
            fields[i].enableFields();//call enableFields on each PersonFields object in the array
        }
    }
}
