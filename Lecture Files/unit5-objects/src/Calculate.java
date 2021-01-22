import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate extends JFrame implements ActionListener {

    private JTextField op1, op2;
    private JLabel plus, equals, result;
    private JButton calulate;


    public static void main(String[] args) {
        Calculate frame = new Calculate();
        frame.setSize(new Dimension(400, 80));
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        setLayout(new FlowLayout());

        //create components
        op1=new JTextField(2);
        op2=new JTextField(2);

        plus=new JLabel("+");
        equals=new JLabel("=");
        result=new JLabel("0");

        calulate=new JButton("calculate");

        //add components
        add(op1);
        add(plus);
        add(op2);
        add(equals);
        add(result);
        add(calulate);

        //register listener
        calulate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int op1=Integer.parseInt(this.op1.getText());
        int op2=Integer.parseInt(this.op2.getText());
        result.setText(""+(op1+op2));
    }
}
