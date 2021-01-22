import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TargetFrame extends JFrame implements ActionListener {
    Target t;

    JButton button;
    JTextField text;
    JPanel buttonPanel, fieldPanel;

    public static void main(String[] args) {
        TargetFrame frame = new TargetFrame();
        frame.setSize(new Dimension(415, 375));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        setLayout(new BorderLayout());
        t = new Target(250, 250);
        setUpButton();
        setUpPanel();
        add(t, BorderLayout.CENTER);
    }

    public void setUpButton() {
        buttonPanel = new JPanel(new FlowLayout());
        button = new JButton("Swap colors!");
        button.addActionListener(this);
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.WEST);
    }

    public void setUpPanel() {
        fieldPanel = new JPanel(new FlowLayout());
        text = new JTextField(25);
        fieldPanel.add(text);
        add(fieldPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            t.swapColors();
            t.repaint();
        }
    }
}
