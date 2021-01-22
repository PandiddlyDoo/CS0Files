package Unit2;

import javax.swing.*;
import java.awt.*;

public class FontCheck extends JFrame {
    public static void main(String[] args) {
        FontCheck frame = new FontCheck();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        String[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }

    }
}