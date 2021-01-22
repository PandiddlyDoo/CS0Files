import javax.swing.*;
import java.awt.*;

public class CheckerPatternFrame extends JFrame {
    CheckerPattern check1=new CheckerPattern();
    CheckerPattern check2=new CheckerPattern();
    CheckerPattern check3=new CheckerPattern();

    public static void main(String[] args) {
        CheckerPatternFrame frame = new CheckerPatternFrame();
        frame.setSize(new Dimension(800, 300));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        Dimension size=new Dimension(256,256);
        check1.setPreferredSize(new Dimension(size));
        check2.setPreferredSize(new Dimension(size));
        check3.setPreferredSize(new Dimension(size));
        setLayout(new FlowLayout());
        this.add(check1);
        this.add(check2);
        this.add(check3);

    }
}
