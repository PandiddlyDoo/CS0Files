package Unit1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TextOverImages extends JFrame implements ActionListener {

    //Assign variables
    private JPanel drawPanel;
    private JButton draw;
    Image img;


    public static void main(String[] args) {
        TextOverImages frame = new TextOverImages();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);
        frame.loadImage();

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components

        //JPanel
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(400, 400));
        drawPanel.setBackground(Color.WHITE);
        //JButton
        draw = new JButton("draw");

        //add components
        window.add(drawPanel);
        window.add(draw);

        //register components
        draw.addActionListener(this);
    }

    public void loadImage(){
        String path = "images/cy.jpg";
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
        g.setColor(Color.RED);
        g.drawString("Hello world!", 50, 275);
    }
}
