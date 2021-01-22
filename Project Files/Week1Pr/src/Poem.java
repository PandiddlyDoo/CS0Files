/**Poem Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Poem extends JFrame implements ActionListener {

    //declaring variables
    private JPanel drawPanel;
    private Image img;
    private JButton draw;

    //Main method as normal w/ loadImage
    public static void main(String[] args) {
        Poem frame = new Poem();
        frame.setSize(new Dimension(600, 700));
        frame.createGUI();
        frame.setVisible(true);
        frame.loadImage();
    }


    //createGUI method as normal w/FlowLayout
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create JPanel set to image size
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(550, 550));
        drawPanel.setBackground(Color.WHITE);
        //create JButton
        draw = new JButton("Poem!");
        //add components
        window.add(drawPanel);
        window.add(draw);

        //register components
        draw.addActionListener(this);
    }

    public void loadImage() {
        String path = "aa.jpg";
        File file = new File(path);
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = drawPanel.getGraphics();
        ImageIcon ico=new ImageIcon(img);
        ico.paintIcon(this, g, 10, 10);
        g.setColor(Color.WHITE);
        g.drawString("\"Prodded Out of Prayer\" --Margret Avison", 275, 50);
        g.setColor(Color.YELLOW);
        g.drawString("Stilled yet by", 50, 75);
        g.drawString("the gauzed withdrawingness of",50, 95);
        g.drawString("midmorning sky:", 50, 115);
        g.setColor(Color.BLACK);
        g.drawString("lo, a sharply lit", 50, 135);
        g.drawString("acutely poignant", 50, 155);
        g.drawString("and wonderfully humorous", 50, 175);
        g.drawString("vision.", 50, 195);
        g.setColor(Color.magenta);
        g.drawString("It was an ant", 50, 215);
        g.drawString("towing a grass-blade", 50, 235);
        g.drawString("in a bee-line, but on", 50, 255);
        g.drawString("rougher terrain,", 50, 275);
        g.drawString("to the anthill.", 50, 295);
    }
}
