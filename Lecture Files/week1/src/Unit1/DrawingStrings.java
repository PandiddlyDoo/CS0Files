package Unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingStrings extends JFrame implements ActionListener {

    private JPanel drawPanel;
    private JButton draw;


    public static void main(String[] args) {
        DrawingStrings frame = new DrawingStrings();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(400, 400));
        drawPanel.setBackground(Color.WHITE);

        draw = new JButton("draw");
        //add components
        window.add(drawPanel);
        window.add(draw);

        //register components
        draw.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = drawPanel.getGraphics();

        g.drawString("Once upon a midnight dreary,", 10, 10);
        g.drawString("while I pondered, weak and weary,", 10, 30);
        g.drawString("Over many a quaint and curious volume of forgotten lore—", 10, 50);
        g.drawString("While I nodded, nearly napping, suddenly there came a tapping,", 10, 70);
        g.drawString("As of some one gently rapping, rapping at my chamber door—", 10, 90);
        g.drawString("\"Tis some visitor,\" I muttered, \"tapping at my chamber door—", 10, 110);
        g.drawString("               Only this and nothing more.\"", 10, 130);


    }
}
