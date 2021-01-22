import javax.swing.*;
import java.awt.*;

public class StringArray1 extends JPanel {
    String[] names;//declare as instance data
    Graphics2D g2d;

    public StringArray1(){
        setPreferredSize(new Dimension(400,100));
        initializeData();
    }

    public void initializeData(){
        names=new String[5];//initialize.  If you don't do this, you get a null pointer exception
        names[0]="Charlie";//assign values to array indices.
        names[1]="Carin";
        names[2]="Lila";
        names[3]="Mace";
        names[4]="Strider";
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawNames();
    }

    public void drawNames(){
        for(int i=0; i<names.length; i++){
            g2d.drawString(names[i], 50, (1+i)*15);
        }
    }
}
