import javax.swing.*;

public class RunStringArray1 extends JFrame {
    StringArray1 sp;
    public static void main(String[]args){
        RunStringArray1 frame=new RunStringArray1();

        frame.setUpGUI();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpGUI(){
        sp=new StringArray1();
        add(sp);
    }

}
