import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SwitchBasics extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 600;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    private JPanel guiPanel;
    private DisplayPanel display;

    JButton random;

    Image img;
    String imgName="taco.jpg";

    public static void main(String[] args) {
        SwitchBasics frame = new SwitchBasics();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.loadImage();
        frame.setUpGUI();
        frame.pack();
        frame.setVisible(true);
    }

    public void randomImage(){
        int choice = (int) (Math.random() * 3) + 1;

        //switch can evaluate byte, short, char, int, enums, String and wrapper classes.
        //the book states that you can only use int and char.  This was changed in Java 7.
        switch (choice) {
            case 1:
                imgName="monkey.jpg";
                break;
            case 2:
                imgName="taco.jpg";
                break;
            case 3:
                imgName="heMan.jpg";
                break;
        }
    }

    public void loadImage(){

        String path = "images/"+imgName;
        File file = new File(path);
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());

        random=new JButton("Random image");
        random.addActionListener(this);

        guiPanel.add(random);

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        randomImage();
        loadImage();
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);invalidate();
            int x=getWidth()/2-img.getWidth(this)/2;
            g.drawImage(img, x,0,this);
        }
    }
}



