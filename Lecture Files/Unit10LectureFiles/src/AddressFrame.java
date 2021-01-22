import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressFrame extends JFrame implements ActionListener {
    AddressFields home;
    AddressFields work;
    BorderLayout border;

    JPanel outputPanel;
    JPanel buttonPanel;
    JPanel addressPanel;

    JTextArea output;
    JScrollPane scroll;
    JButton submit, clear;

    String outputString;
    public static void main(String[] args) {
        AddressFrame frame = new AddressFrame();
        frame.setSize(new Dimension(600, 325));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        border=new BorderLayout();
        setLayout(border);
        setUpOutput();
        setUpButtons();
        setUpAddress();
    }

    public void setUpAddress(){
        addressPanel=new JPanel();
        BoxLayout box=new BoxLayout(addressPanel, BoxLayout.Y_AXIS);
        addressPanel.setLayout(box);
        home=new AddressFields("Home");
        work=new AddressFields("Work");
        addressPanel.add(home);
        addressPanel.add(work);
        add(addressPanel, BorderLayout.WEST);
    }

    public void setUpOutput(){
        outputPanel=new JPanel(new FlowLayout());
        output=new JTextArea(15,20);
        scroll=new JScrollPane(output);
        outputPanel.add(scroll);
        add(outputPanel, BorderLayout.CENTER);
    }

    public void setUpButtons(){
        buttonPanel=new JPanel(new FlowLayout());
        submit=new JButton("Submit");
        clear=new JButton("Clear");
        buttonPanel.add(submit);
        buttonPanel.add(clear);
        add(buttonPanel, BorderLayout.SOUTH);
        submit.addActionListener(this);
        clear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventButton=(JButton)e.getSource();

        if(eventButton==submit){
            buildOutputString();
            output.append(outputString);
            outputString="";
        }
        if(eventButton==clear){
            output.setText("");
        }
        home.clearFields();
        work.clearFields();
    }

    public void buildOutputString(){
        //name, street, city, state, zip
        String homeText="Home:\n"+home.nameField.getText()+"\nStreet: "+home.streetField.getText()+
                "\nCity: "+home.cityField.getText()+"\nState: "+home.stateField.getText()+"\nZip: "+home.zipField.getText()+"\n";
        String workText="Work:\n"+work.nameField.getText()+"\nStreet: "+work.streetField.getText()+
                "\nCity: "+work.cityField.getText()+"\nState: "+work.stateField.getText()+"\nZip: "+work.zipField.getText()+"\n";
        outputString=homeText+workText;
    }
}
