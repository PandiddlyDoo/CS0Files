/**Translator Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataInputAndSearch extends JFrame implements ActionListener {
    private String[] englishWords = {"Hello", "Yes", "No", "Thanks", "Please", "Sorry" };
    private String[] hebrewWords = {"Shalom", "Chen", "Lo", "Toda", "Bevakasha", "Slicha"};
    private String[] imageString= {"Hello.jpg", "Yes.jpg", "No.jpg", "Thanks.jpg", "Please.jpg", "Sorry.jpg"};

    private JPanel inputPanel, outputPanel, searchPanel;
    private JButton searchButton, submitButton, finishButton;
    private JLabel searchFieldLabel, searchOutputLabel, inputLabel;
    private JTextField searchField, inputField;
    private JTextArea outputArea;

    private String[] inputData;
    private int inputCounter=0;
    private int MAX_INPUTS=50;

    public static void main(String[] args) {
        DataInputAndSearch frame = new DataInputAndSearch();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpGUI(){
        setUpButtons();
        setUpFields();
        setUpLabels();
        setUpPanels();
        inputData=new String[MAX_INPUTS];
    }

    public void setUpButtons(){
        searchButton=new JButton("search");
        searchButton.setEnabled(false);
        submitButton=new JButton("submit");
        finishButton=new JButton("finish");

        searchButton.addActionListener(this);
        submitButton.addActionListener(this);
        finishButton.addActionListener(this);
    }

    public void setUpFields(){
        searchField=new JTextField(15);
        inputField=new JTextField(15);
        outputArea=new JTextArea(15, 15);
    }

    public void setUpLabels(){
        searchFieldLabel=new JLabel("Search for data");
        searchOutputLabel=new JLabel("");
        inputLabel=new JLabel("enter strings");
    }

    public void setUpPanels(){
        inputPanel=new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(submitButton);
        inputPanel.add(finishButton);

        outputPanel=new JPanel(new FlowLayout());
        outputPanel.add(outputArea);

        searchPanel=new JPanel(new FlowLayout());
        searchPanel.add(searchFieldLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(searchOutputLabel);

        add(outputPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submitButton){
            inputData[inputCounter]=inputField.getText();
            inputCounter++;
            inputField.setText("");

        }if (e.getSource()==finishButton){
            for (int i=0; i<inputData.length; i++){
                if(inputData[i] !=null) {
                    outputArea.append(inputData[i] + "\n");
                }
                submitButton.setEnabled(false);
                finishButton.setEnabled(false);
                searchButton.setEnabled(true);
            }

        }if(e.getSource()==searchButton) {
           int temp=search(inputData, searchField.getText());

           if(temp>0){
               searchOutputLabel.setText(inputData[temp]);
           }else{
               searchOutputLabel.setText("not found");
           }
        }

    }

    public int search(String[] arr,  String target){
        int foundIndex=-1;
        int count=0;

        while(foundIndex<0&&count<arr.length){
            if(arr[count]!=null&&arr[count].equalsIgnoreCase(target)){
                foundIndex=count;
            }else{
                count++;
            }

        }

        return foundIndex;
    }
}
