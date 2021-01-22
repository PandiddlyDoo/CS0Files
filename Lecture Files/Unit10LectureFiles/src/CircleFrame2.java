import javax.swing.*;
import java.awt.*;

public class CircleFrame2 extends JFrame {
    BorderLayout border;
    JPanel titlePanel, circleAndControl1, circleAndControl2, centerContainer;
    JLabel title;
    Circle circle1, circle2;
    CircleControl control1, control2;

    public static void main(String[] args) {
        CircleFrame2 frame = new CircleFrame2();
        frame.setSize(new Dimension(800, 400));
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
        title=new JLabel("Change the circle!");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    public void setUpCenter(){
        centerContainer=new JPanel(new FlowLayout());
        circleAndControl1=new JPanel(new BorderLayout());
        circleAndControl1.setBorder(BorderFactory.createLineBorder(Color.black));
        circleAndControl2=new JPanel(new BorderLayout());
        circleAndControl2.setBorder(BorderFactory.createLineBorder(Color.black));

        setUpCircles();
        setUpControls();

        circle1.setPreferredSize(new Dimension(250,250));
        circle2.setPreferredSize(new Dimension(250,250));

        circleAndControl1.add(circle1, BorderLayout.CENTER);
        circleAndControl1.add(control1, BorderLayout.SOUTH);
        circleAndControl2.add(circle2, BorderLayout.CENTER);
        circleAndControl2.add(control2, BorderLayout.SOUTH);

        centerContainer.add(circleAndControl1);
        centerContainer.add(circleAndControl2);

        add(centerContainer, BorderLayout.CENTER);
    }

    public void setUpCircles(){
        circle1=new Circle(0, 0,250, 250);
        circle2=new Circle(0, 0,250, 250);
    }

    public void setUpControls(){
        control1=new CircleControl(circle1);
        control2=new CircleControl(circle2);
    }
}
