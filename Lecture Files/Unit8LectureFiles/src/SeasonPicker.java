import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SeasonPicker extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 400;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH;

    JButton update;

    Calendar curentTime;
    int hour, min, sec;
    int month;
    String season;
    private JPanel guiPanel;
    private DisplayPanel display;


    public static void main(String[] args) {
        SeasonPicker frame = new SeasonPicker();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();

        frame.updateCalendar();
        frame.updateTime();
        frame.updateSeason();

        frame.pack();
        frame.setVisible(true);
    }


    public void updateTime(){
        hour=curentTime.get(Calendar.HOUR_OF_DAY);
        min=curentTime.get(Calendar.MINUTE);
        sec=curentTime.get(Calendar.SECOND);
    }

    public void updateSeason(){
        month=curentTime.get(Calendar.MONTH);

        switch(month){
            case Calendar.DECEMBER:
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
                season="winter";
                break;
            case Calendar.MARCH:
            case Calendar.APRIL:
            case Calendar.MAY:
                season="spring";
                break;
            case Calendar.JUNE:
            case Calendar.JULY:
            case Calendar.AUGUST:
                season="summer";
                break;
            case Calendar.SEPTEMBER:
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
                season="fall";
                break;
        }
    }

    public void updateCalendar(){
        curentTime=Calendar.getInstance();
    }


    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());

        update=new JButton("update");
        update.addActionListener(this);
        guiPanel.add(update);

        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateCalendar();
        updateTime();
        updateSeason();
        display.repaint();
    }

    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);

        }

        public void paintComponent(Graphics g) {
            switch(season){
                case "winter":
                    g.setColor(new Color(208, 218, 255));
                    break;
                case "spring":
                    g.setColor(new Color(181, 255, 92));
                    break;
                case "summer":
                    g.setColor(new Color(9, 102, 54));
                case "fall":
                    g.setColor(new Color(165, 97, 0));
                    break;
            }//end switch

            g.fillRect(0,0,getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("Season: "+season+
                    " Time of Day: "+hour+
                    ":"+min+":"+sec, 25, 50);
        }
    }
}


