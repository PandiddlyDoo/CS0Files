import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MethodBasics extends JFrame {
    Image img, img2;
    public static void main(String[]args){
        MethodBasics frame= new MethodBasics();
        frame.setSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.loadImage();
        frame.setVisible(true);
    }

    public void loadImage(){
        String path1 = "images/macer.jpg";
        String path2 = "images/pic.jpg";
        File file = new File(path1);
        File file2 = new File(path2);
        try {
            img = ImageIO.read(file);
            img2 = ImageIO.read(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        //set up anti-aliasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawFramedImage(img, 50,50, Color.RED, g2d, "Pic of Macer");
        drawFramedImage(img2, 250,330, Color.GREEN, g2d, "Pic of Egypt");
        drawFramedImage(img, 250,75, Color.yellow, g2d, "Pic of Macer");
    }

    public void drawFramedImage(Image img, int locX, int locY,
                                Color c, Graphics2D g, String caption){
        int imgHeight=img.getHeight(this);
        int imgWidth=img.getWidth(this);

        g.setColor(c);
        g.fillRect(locX-25, locY-25, imgWidth+50, imgHeight+75);

        g.setColor(Color.BLACK);
        g.drawRect(locX-25, locY-25, imgWidth+50, imgHeight+75);

        g.drawImage(img, locX, locY,this);

        g.drawString(caption, locX, locY+imgHeight+30);

    }//end drawFramedImages
}
