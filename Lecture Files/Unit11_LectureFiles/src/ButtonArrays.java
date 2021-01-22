import javax.swing.*;
import java.awt.*;

public class ButtonArrays extends JPanel {
    String buttonNames[]={"up", "down", "left", "right"};
    String radioNames[]={"red", "green", "blue", "orange"};

    JRadioButton[] radios;
    JButton[] buttons;

    JPanel buttonPanel, radioPanel;

    public ButtonArrays(){
        setPreferredSize(new Dimension(400,120));
        setLayout(new GridLayout(2,1));
        setUpButtons();
        setUpRadios();
    }
    public void setUpButtons(){
        buttonPanel=new JPanel(new FlowLayout());
        buttons=new JButton[buttonNames.length];

        for(int i=0; i<buttons.length; i++){
            buttons[i]=new JButton(buttonNames[i]);
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel);
    }

    public void setUpRadios(){
        ButtonGroup grp=new ButtonGroup();
        radioPanel=new JPanel(new FlowLayout());
        radios=new JRadioButton[radioNames.length];

        for(int i=0; i<radios.length; i++){
            radios[i]=new JRadioButton(radioNames[i]);
            grp.add(radios[i]);
            radioPanel.add(radios[i]);
        }

        add(radioPanel);
    }
}
