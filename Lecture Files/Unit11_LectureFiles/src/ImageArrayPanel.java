import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageArrayPanel extends JPanel{
    Image[] pics;
    String[] names={"bun.jpg", "cat.jpg", "lipe.jpg",
            "mace.jpg", "baby.jpg", "peanut.jpg", "babies.jpg", "squirrel.jpg", "woof.jpg"};


    final int NUM_PICS=names.length;

    JPanel imagePanel;

    Image currentImage;

    ImageIcon icon;
    JLabel imageLabel;

    public ImageArrayPanel(){
        loadAllImages();
        setUpImagePanel();
    }

    public void nextImage(int i){
        currentImage=pics[i];
        icon.setImage(currentImage);
        repaint();
    }

    public void loadAllImages(){
        pics=new Image[NUM_PICS];
        for(int i=0; i<NUM_PICS; i++){
            loadImage(names[i], i);
        }
    }

    public void loadImage(String name, int index){
        String path = "images/"+name;
        File file = new File(path);
        try {
            pics[index] = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpImagePanel(){
        imagePanel=new JPanel(new FlowLayout());
        imageLabel=new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        currentImage=pics[0];

        icon=new ImageIcon();
        icon.setImage(currentImage);
        imageLabel.setIcon(icon);

        imagePanel.add(imageLabel);

        add(imagePanel);
    }

}