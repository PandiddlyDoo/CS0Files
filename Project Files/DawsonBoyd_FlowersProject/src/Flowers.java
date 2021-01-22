/**Flowers Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Flowers extends JFrame {

    //assign var
    private JPanel drawPanel;
    Image img;
    int xShift, yShift;

    //main method with correct size, using loadImage as the first call so that the image can be found before it's cast to the frame
    public static void main(String[] args) {
        Flowers frame = new Flowers();
        frame.loadImage();
        frame.setSize(1024, 736);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Programming Plants");
        frame.xShift=250;
        frame.yShift=50;
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components

        //JPanel with correct size
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(1024, 736));
        drawPanel.setBackground(Color.WHITE);

        //add components
        window.add(drawPanel);
    }
    //loadImage paste from week1
    public void loadImage () {
        String path = "ab.png";
        File file = new File(path);
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public void paint (Graphics g){
            super.paint(g);
            //Antialiasing, drawing images, and declaring fonts so they can be called anywhere
            Graphics2D g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(img, 0, 0, null);
            Font title = new Font("Helvetica", Font.BOLD, 30);
            Font subTitle = new Font("Arial", Font.ITALIC, 20);
            Font desc = new Font("Arial", Font.PLAIN, 12);


            //Drawing boxes and descriptions
            g2d.drawRect(250, 40, 480, 60);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(40, 130, 450, 250);
            g2d.fillRect(530, 130, 450, 250);
            g2d.fillRect(40, 420, 450, 250);
            g2d.fillRect(530, 420, 450, 250);

            g2d.setFont(title);
            g2d.setColor(Color.RED);
            g2d.drawString("PROGRAMMING PLANTS", 300, 80);

            g2d.setFont(subTitle);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Tulip", 300, 170);
            g2d.drawString("Sacred Rose", 790, 170);
            g2d.drawString("Blueberry Bush", 270, 460);
            g2d.drawString("Compass \"Rose\"", 790, 460);

            g2d.setFont(desc);
            g2d.drawString("The tulip is a classic flower,", 220, 190);
            g2d.drawString("often associated with true love or royalty.", 220, 200);
            g2d.drawString("The sacred rose and its alluring geometry", 720, 190);
            g2d.drawString("can be appealing.", 735, 200);
            g2d.drawString("Try not to speak latin around this flower.", 750, 220);
            g2d.drawString("This sweet summer treat can be a tasty snack!", 230, 480);
            g2d.drawString("This \"Rose\" is a funny play on words.", 730, 480);
            g2d.drawString("Also good practice for evenly sized polygons", 730, 500);
            g2d.drawString("in different orientations!", 735, 510);






            //The flowers!
            //anything green
            g2d.setColor(Color.GREEN);
            g2d.fillOval(125, 270, 60, 30);
            g2d.fillRect(120, 260, 20, 120);


            //Bush
            g2d.fillOval(70, 520, 220, 150);
            g2d.fillOval(65, 610, 60, 60);
            g2d.fillOval(50, 580, 60, 60);
            g2d.fillOval(55, 540, 60, 60);
            g2d.fillOval(80, 510, 60, 60);
            g2d.fillOval(120, 510, 60, 60);
            g2d.fillOval(160, 500, 60, 60);
            g2d.fillOval(200, 510, 60, 60);
            g2d.fillOval(240, 540, 60, 60);
            g2d.fillOval(250, 580, 60, 60);
            g2d.fillOval(235, 610, 60, 60);
            g2d.fillRect(80, 650, 200, 20);


            //Blueberries
            g2d.setColor(Color.BLUE);
            g2d.fillOval(80, 630, 10, 10);
            g2d.fillOval(70, 620, 10, 10);
            g2d.fillOval(90, 530, 10, 10);
            g2d.fillOval(110, 600, 10, 10);
            g2d.fillOval(120, 600, 10, 10);
            g2d.fillOval(140, 620, 10, 10);
            g2d.fillOval(115, 550, 10, 10);
            g2d.fillOval(160, 580, 10, 10);
            g2d.fillOval(180, 520, 10, 10);
            g2d.fillOval(190, 590, 10, 10);
            g2d.fillOval(195, 610, 10, 10);
            g2d.fillOval(220, 530, 10, 10);
            g2d.fillOval(235, 610, 10, 10);
            g2d.fillOval(250, 570, 10, 10);
            g2d.fillOval(270, 630, 10, 10);


            //anything red
            g2d.setColor(Color.red);
            g2d.fillArc(87, 165, 90, 100, 120, 300); //Tulip Bulb
            g2d.fillOval(550, 160, 200, 200); //Rose base


            //anything black
            g2d.setColor(Color.black);
            //Rose
            Polygon p1=new Polygon();
            p1.addPoint(650, 160);
            p1.addPoint(750,260);
            p1.addPoint(650,360);
            p1.addPoint(550, 260);
            g2d.drawPolygon(p1);
            g2d.drawRect(580, 190, 140, 140);
            Polygon p2=new Polygon();
            p2.addPoint(650, 190);
            p2.addPoint(720, 260);
            p2.addPoint(650, 330);
            p2.addPoint(580, 260);
            g2d.drawPolygon(p2);
            g2d.drawLine(650, 190, 650, 330);
            g2d.drawLine(720, 260, 580, 260);
            g2d.drawLine(580, 190, 720, 330);
            g2d.drawLine(580, 330, 720, 190);
            g2d.drawOval(600, 210, 100, 100);


            //compass rose petals
            //OUTER
            g2d.setColor(Color.gray);
            Polygon p3=new Polygon();
            p3.addPoint(620,520);
            p3.addPoint(530, 550);
            p3.addPoint(620, 580);
            g2d.fillPolygon(p3);

            Polygon p4=new Polygon();
            p4.addPoint(620, 520);
            p4.addPoint(650, 430);
            p4.addPoint(680, 520);
            g2d.fillPolygon(p4);

            Polygon p5=new Polygon();
            p5.addPoint(680, 520);
            p5.addPoint(770, 550);
            p5.addPoint(680, 580);
            g2d.fillPolygon(p5);

            Polygon p6=new Polygon();
            p6.addPoint(680, 580);
            p6.addPoint(650, 670);
            p6.addPoint(620, 580);
            g2d.fillPolygon(p6);


            //INNER
            g2d.setColor(Color.darkGray);
            Polygon p7=new Polygon();
            p7.addPoint(620,520);
            p7.addPoint(650, 550);
            p7.addPoint(620, 580);
            g2d.fillPolygon(p7);

            Polygon p8=new Polygon();
            p8.addPoint(620, 520);
            p8.addPoint(650, 550);
            p8.addPoint(680, 520);
            g2d.fillPolygon(p8);

            Polygon p9=new Polygon();
            p9.addPoint(680, 520);
            p9.addPoint(650, 550);
            p9.addPoint(680, 580);
            g2d.fillPolygon(p9);

            Polygon p10=new Polygon();
            p10.addPoint(680, 580);
            p10.addPoint(650, 550);
            p10.addPoint(620, 580);
            g2d.fillPolygon(p10);







        }
}
