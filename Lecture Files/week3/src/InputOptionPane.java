import javax.swing.*;
import java.awt.*;

public class InputOptionPane extends JFrame {

    //instance variables can be used in all methods!
    int num1, num2, sum;
    String input;
    JLabel output;

    public static void main(String[] args) {
        InputOptionPane frame = new InputOptionPane();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        //create components
        output=new JLabel("output");
        //add components
        window.add(output);

        //get input from JOptionPane
        input=JOptionPane.showInputDialog(window, "Please enter an int");
        num1=Integer.parseInt(input);

        //now use num2 and sum to add the values in the variables together
        //output the sum on the label
        output.setText(input);

    }
}
