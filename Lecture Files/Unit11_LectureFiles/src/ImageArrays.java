import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ImageArrays extends JFrame implements ActionListener {
    private JPanel guiPanel;

    int imgCount=1;
    JPanel controls;
    JButton randomize;

    ImageArrayPanel panel;

    public static void main(String[] args) {
        ImageArrays frame = new ImageArrays();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setUpGUI();

        frame.pack();
        frame.setVisible(true);
    }


    public void setUpGUI() {
        setLayout(new BorderLayout());
        guiPanel = new JPanel(new FlowLayout());

        setUpControls();
        setUpImagePanel();

        add(guiPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }
    public void setUpControls(){
        controls=new JPanel(new FlowLayout());
        randomize=new JButton("randomize");
        randomize.addActionListener(this);
        controls.add(randomize);
        guiPanel.add(controls);
    }

    public void setUpImagePanel(){
        panel=new ImageArrayPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button=e.getSource();

        if(button==randomize){
            if(imgCount<panel.NUM_PICS) {
                panel.nextImage(imgCount);
                imgCount++;
            }
            else{
                imgCount=0;
                panel.nextImage(imgCount);
                imgCount++;
            }
        }

    }

}


