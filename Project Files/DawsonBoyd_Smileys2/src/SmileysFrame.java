/**Smiley2 Project
 * @author Dawson Boyd
 * @version Fall 2020
 * CSci 1130
 */
import javax.swing.*;
import java.awt.*;

//All the GUI stuff shoved in this class
public class SmileysFrame extends JFrame {
    BorderLayout border;
    JPanel titlePanel, circleAndControl1, circleAndControl2, circleAndControl3, centerContainer;
    JLabel title;
    Smiley smile1, smile2, smile3;
    SmileControl control1, control2, control3;

    public static void main(String[] args) {
        SmileysFrame frame = new SmileysFrame();
        frame.setSize(new Dimension(1600, 650));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        border=new BorderLayout();
        setLayout(border);
        setUpTitle();
        setUpCenter();
    }

    public void setUpTitle(){
        titlePanel=new JPanel(new FlowLayout());
        title=new JLabel("Change the Smiley!");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    public void setUpCenter(){
        centerContainer=new JPanel(new FlowLayout());
        circleAndControl1=new JPanel(new BorderLayout());
        circleAndControl1.setBorder(BorderFactory.createLineBorder(Color.black));
        circleAndControl2=new JPanel(new BorderLayout());
        circleAndControl2.setBorder(BorderFactory.createLineBorder(Color.black));
        circleAndControl3=new JPanel(new BorderLayout());
        circleAndControl3.setBorder(BorderFactory.createLineBorder(Color.black));

        setUpCircles();
        setUpControls();

        smile1.setPreferredSize(new Dimension(500,500));
        smile2.setPreferredSize(new Dimension(500,500));
        smile3.setPreferredSize(new Dimension(500,500));

        circleAndControl1.add(smile1, BorderLayout.CENTER);
        circleAndControl1.add(control1, BorderLayout.SOUTH);
        circleAndControl2.add(smile2, BorderLayout.CENTER);
        circleAndControl2.add(control2, BorderLayout.SOUTH);
        circleAndControl3.add(smile3, BorderLayout.CENTER);
        circleAndControl3.add(control3, BorderLayout.SOUTH);

        centerContainer.add(circleAndControl1);
        centerContainer.add(circleAndControl2);
        centerContainer.add(circleAndControl3);

        add(centerContainer, BorderLayout.CENTER);
    }

    //initial smiles
    public void setUpCircles(){
        smile1=new Smiley(25, 25,250, 250);
        smile2=new Smiley(25, 25,250, 250);
        smile3=new Smiley(25, 25, 250, 250);
    }

    public void setUpControls(){
        control1=new SmileControl(smile1);
        control2=new SmileControl(smile2);
        control3=new SmileControl(smile3);
    }
}
