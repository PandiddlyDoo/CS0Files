package Unit2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicDrawingTemplate extends JFrame implements ActionListener {

    private JPanel drawPanel;
    private JButton draw;


    public static void main(String []args){
        BasicDrawingTemplate frame= new BasicDrawingTemplate();
        frame.setSize(new Dimension(400, 600));
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window=getContentPane();
        window.setLayout(new FlowLayout());

        //create components
        drawPanel=new JPanel();
        drawPanel.setPreferredSize(new Dimension(400,400));
        drawPanel.setBackground(Color.WHITE);

        draw=new JButton("draw");
        //add components
        window.add(drawPanel);
        window.add(draw);

        //register components
        draw.addActionListener(this);
    }

    private void drawingMethod(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g=drawPanel.getGraphics();
        g.drawRect(drawPanel.getWidth()/2-100,drawPanel.getHeight()/2-100,200,200);
    }
}
