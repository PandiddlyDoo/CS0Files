import javax.swing.*;
import java.awt.*;

public class TextAreaBasics extends JFrame {
    JTextArea area1, area2, area3;

    public static void main(String[] args) {
        TextAreaBasics frame = new TextAreaBasics();
        frame.setSize(new Dimension(400, 200));
        frame.setLayout(new FlowLayout());
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        //default has no defined rows and cols
        area1 = new JTextArea();

        //set the rows and columns in the constructor
        area2 = new JTextArea(5, 15);
        area2.setLineWrap(true);//line wrap will force text to a new line when it reaches the edge of the area
        area2.setWrapStyleWord(true);//will wrap at the nearest word

        area3 = new JTextArea("Text area with text", 1, 25);
        area3.setForeground(Color.GREEN);
        area3.setBackground(Color.black);

        window.add(area1);
        window.add(area2);
        window.add(area3);

        String text = "Text can be appended to a text area like this!";
        area2.append(text);
    }
}
