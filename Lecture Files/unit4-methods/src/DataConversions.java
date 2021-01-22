import javax.swing.*;
import java.awt.*;

public class DataConversions extends JFrame {
    int iNum;
    double dNum;
    float fNum;
    long lNum;
    char ch;

    public static void main(String[]args){
        DataConversions frame= new DataConversions();
        frame.setSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.initializeVariables();

        frame.setVisible(true);


    }

    public void initializeVariables(){
        iNum = 75;
        dNum = 12.25;
        fNum = 12.5f;
        lNum = 12345;
        ch = 'A';
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //widening conversions acceptable
        long lResult = iNum;
        System.out.println("lResult: " + lResult);
        g2d.drawString(""+lResult, 10 , 10);

        double dResult = lNum;
        System.out.println("dResult: " + dResult);
        g2d.drawString(""+dResult, 50 , 50);

        //narrowing conversions not acceptable
        //int iresult=dNum;
        //int iresult=lNum;

        //working with chars
        int charToInt = ch;
        System.out.println("Char to int: " + charToInt);
        g2d.drawString(""+charToInt, 50 , 90);
        //using a cast to change an int to a char
        char chResult = (char) iNum;
        System.out.println("int to char: " + chResult);
        g2d.drawString(""+chResult, 50 , 115);
    }
}
