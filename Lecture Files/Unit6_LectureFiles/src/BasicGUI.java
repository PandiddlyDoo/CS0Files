import javax.swing.*;
import java.awt.*;

public class BasicGUI extends JFrame {

    public static void main(String[] args) {
        BasicGUI frame = new BasicGUI();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        //create components

        //add components
    }
}
