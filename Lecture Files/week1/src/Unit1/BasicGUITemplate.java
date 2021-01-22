package Unit1;

import javax.swing.*;
import java.awt.*;

public class BasicGUITemplate extends JFrame {

    public static void main(String []args){
        BasicGUITemplate frame= new BasicGUITemplate();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window=getContentPane();

        //create components

        //add components
    }
}
