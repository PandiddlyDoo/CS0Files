package Unit1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UsingImages extends JFrame {

    private Image img;
    private JLabel imageLabel, textLable;
    private ImageIcon icon;

    public static void main(String[] args) {
        UsingImages frame = new UsingImages();
        frame.setSize(new Dimension(400, 375));
        frame.setLayout(new FlowLayout());

        frame.loadImage();
        frame.createGUI();


        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadImage(){
        //below you will find three ways of writing the path to the image
        /*absolute path: The absolute path will look
        for the image file starting at the root directory of your
        file system. This works great on your computer, but
        not when you try to compile this same file on
        another comptuer.  See the absolute path that
        I provided, it references directories that do
         not exist on your computer.
         */
        String path1 = "C:\\Users\\cgorrill\\Dropbox\\1130 materials Spring 2019 and on\\LectureFiles\\week1\\src\\Unit1\\cy.jpg";
        /*
        * below is away of making a relative path
        * this will look in the project root and follow the
        * path down through src to unit1 in order to find
        * the image.  Using relative paths is preferable to
        * absolute paths.
        * */
        String path2 = "src/Unit1/cy.jpg";
        //This path will locate the image in the images directory.
        String path3 ="images/cy.jpg";

        File file = new File(path3);
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        //create components
        imageLabel=new JLabel();
        textLable=new JLabel("Cy Twombly: Tiznit 1953");
        icon=new ImageIcon();
        icon.setImage(img);

        //add components
        window.add(imageLabel);
        imageLabel.setIcon(icon);
        window.add(textLable);
    }
}
