/**Translator Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Translator extends JFrame implements ActionListener {
    private String[] englishWords = {"Hello", "Yes", "No", "Thanks", "Please", "Sorry" };
    private String[] hebrewWords = {"Shalom", "Chen", "Lo", "Toda", "Bevakasha", "Slicha"};

    private JPanel searchPanel;
    private JButton searchButton;
    private JLabel searchFieldLabel, searchOutputLabel, inputLabel;
    private JTextField searchField, inputField;

    private int inputCounter=0;

    ImagePanel panel;

    public static void main(String[] args) {
        Translator frame = new Translator();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 650));
        frame.pack();
        frame.setUpGUI();
        frame.setVisible(true);
    }

    public void setUpGUI(){
        setUpButtons();
        setUpFields();
        setUpLabels();
        setUpPanels();
    }

    public void setUpButtons(){
        searchButton=new JButton("Translate word");

        searchButton.addActionListener(this);
    }

    public void setUpFields() {
        searchField = new JTextField(15);
        inputField = new JTextField(15);
    }

    public void setUpLabels(){
        searchFieldLabel=new JLabel("in hebrew means:");
        searchOutputLabel=new JLabel("");
        inputLabel=new JLabel("Enter English word");
    }

    public void setUpPanels(){
        searchPanel=new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        searchPanel.add(inputLabel);
        searchPanel.add(inputField);
        searchPanel.add(searchFieldLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(searchOutputLabel);

        panel=new ImagePanel();

        add(panel, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==searchButton) {
            int temp=search(englishWords, inputField.getText());

            if(temp>-1){
                searchField.setText(hebrewWords[temp]);
            }else{
                searchOutputLabel.setText("Not valid");
                panel.invalidWord();
            }
            inputField.setText("");
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
