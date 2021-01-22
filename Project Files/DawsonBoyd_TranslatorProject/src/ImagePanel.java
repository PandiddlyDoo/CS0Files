import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{
    Image[] pics;
    String[] names={"Hello.png", "Yes.png", "No.png", "Thanks.png", "Please.png", "Sorry.png", "Noimg.png", "Enter.png"};


    final int NUM_PICS=names.length;

    JPanel imagePanel;

    static Image currentImage;

    ImageIcon icon;
    JLabel imageLabel;

    public ImagePanel(){
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

        currentImage=pics[7];

        icon=new ImageIcon();
        icon.setImage(currentImage);
        imageLabel.setIcon(icon);

        imagePanel.add(imageLabel);

        add(imagePanel);
    }

    public void invalidWord(){
        currentImage=pics[6];
        icon.setImage(currentImage);
        imageLabel.setIcon(icon);
        imageLabel.repaint();
        imageLabel.revalidate();
    }

}
