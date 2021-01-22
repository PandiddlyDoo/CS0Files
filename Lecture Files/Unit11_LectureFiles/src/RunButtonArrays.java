import javax.swing.*;

public class RunButtonArrays extends JFrame {
    ButtonArrays arr;
    public static void main(String []args){
        RunButtonArrays frame= new RunButtonArrays();
        frame.setUpGUI();
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpGUI(){
        arr=new ButtonArrays();
        add(arr);
    }
}
