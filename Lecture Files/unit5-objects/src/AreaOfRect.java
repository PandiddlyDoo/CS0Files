import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class AreaOfRect extends JFrame implements ActionListener {

    private JPanel drawPanel;
    private JButton draw;
    private int height, width, area;
    private Point origin;
    private JTextField heightField, widthField, xField, yField;
    private JLabel heightLabel, widthLabel, xLabel, yLabel;

    public static void main(String[] args) {
        AreaOfRect frame = new AreaOfRect();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //create components
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(400, 400));
        drawPanel.setBackground(Color.WHITE);

        draw = new JButton("draw");
        heightField= new JTextField(3);
        widthField=new JTextField(3);
        xField=new JTextField(3);
        yField=new JTextField(3);
        heightLabel=new JLabel("Height");
        widthLabel=new JLabel("Width");
        xLabel=new JLabel("Origin x");
        yLabel=new JLabel("Origin y");

        //instantiate Point or else nullPointer
        origin=new Point();
        //add components
        window.add(drawPanel);
        window.add(widthLabel);
        window.add(widthField);
        window.add(heightLabel);
        window.add(heightField);
        window.add(xLabel);
        window.add(xField);
        window.add(yLabel);
        window.add(yField);
        window.add(draw);

        //register components
        draw.addActionListener(this);
    }


    public void updateVariables(){
        width=parseInt(widthField.getText());
        height=parseInt(heightField.getText());
        origin.setLocation(parseInt(xField.getText()), parseInt(yField.getText()));
        area=width*height;
        System.out.printf("H: %d,%nW: %d,%nX: %.1f,%nY: %.1f,%n", height, width, origin.getX(), origin.getY());
    }

    public int parseInt(String s){
        return Integer.parseInt(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateVariables();
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,drawPanel.getWidth(), drawPanel.getHeight());
        g.setColor(Color.WHITE.BLACK);
        g.drawRect((int)origin.getX(), (int)origin.getY(), width,height );

        g.drawString("Area: "+area,(int)origin.getX(), (int)origin.getY()-5);
    }
}
