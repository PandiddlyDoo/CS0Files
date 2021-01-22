import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class LakeLazyDayz extends JFrame implements ActionListener {
    private final int DISPLAY_WIDTH = 800;
    private final int DISPLAY_HEIGHT = DISPLAY_WIDTH/2;

    JButton submit;

    Calendar currentTime;
    int month;
    String season;
    private JPanel guiPanel;
    private DisplayPanel display;
    private JTextField wInput, tInput;
    String weather, temperature;
    int tempInt;
    String activity = "";
    Image img;
    String imgName="fall.jpg";


    public static void main(String[] args) {
        LakeLazyDayz frame = new LakeLazyDayz();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setUpGUI();

        frame.updateCalendar();
        frame.updateSeason();

        frame.pack();
        frame.setVisible(true);
    }



    public void updateSeason(){
        month=currentTime.get(Calendar.MONTH);

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
        currentTime=Calendar.getInstance();
    }


    public void setUpGUI() {
        Container window = getContentPane();
        display = new DisplayPanel();
        guiPanel = new JPanel(new FlowLayout());
        tInput = new JTextField("Enter temperature");
        wInput = new JTextField("Precipitation, Sunny, Windy");


        submit=new JButton("Enter");
        submit.addActionListener(this);
        guiPanel.add(submit);
        guiPanel.add(tInput);
        guiPanel.add(wInput);



        window.add(guiPanel, BorderLayout.SOUTH);
        window.add(display, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateCalendar();
        updateSeason();

        weather=wInput.getText();
        temperature=tInput.getText();
        if (!(weather.equalsIgnoreCase("Precipitation") ||
                weather.equalsIgnoreCase("Sunny") ||
                weather.equalsIgnoreCase("Windy"))) {
            wInput.setText("INVALID! Precipitation, Sunny, or Windy");
        }else{
            giveActivity();
            display.repaint();
        }

    }

    public void giveActivity() {
        int tempInt = Integer.parseInt(temperature);
        switch(season){
            case "winter":
                if (tempInt>15&&tempInt<50){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Ski";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Sled";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Skate"; }

                else if (tempInt > 0){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Snowmobile";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Skate";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Ice fish";
                }else if (tempInt < 0) {
                    activity = "Stay inside";
                }else if (tempInt > 50){
                    activity = "Move somewhere colder";
                }
                break;

            case "spring":
                if (tempInt>40&&tempInt<60){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Jog";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Stay inside";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Fly a kite"; }

                else if (tempInt > 60 && tempInt < 80){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Golf";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Go fishing";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Fly a kite";
                }else if (tempInt < 40) {
                    activity = "Put on a jacket";
                }else if (tempInt > 80){
                    activity = "Move somewhere colder";
                }
                break;

            case "summer":
                if (tempInt>60&&tempInt<80){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Sunbathe ";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Stay Inside";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Go swimming"; }

                else if (tempInt > 80 && tempInt < 100){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Go swimming";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Go fishing";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Rock Climb";
                }else if (tempInt < 60) {
                    activity = "Golf";
                }else if (tempInt > 100){
                    activity = "Stay inside";
                }

            case "fall":
                if (tempInt>30&&tempInt<60){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Soccer";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Stay Inside";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Rake leaves"; }

                else if (tempInt > 60 && tempInt < 80){
                    if(weather.equalsIgnoreCase("Sunny"))
                        activity = "Play tennis";
                    else if (weather.equalsIgnoreCase("Precipitation"))
                        activity = "Stay inside";
                    else if (weather.equalsIgnoreCase("Windy"))
                        activity= "Rake leaves";
                }else if (tempInt < 30) {
                    activity = "Put on a jacket";
                }else if (tempInt > 80){
                    activity = "Swim";
                }
                break;
        }//end switch

    }

    class DisplayPanel extends JPanel {
        DisplayPanel() {
            setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            this.setBackground(Color.WHITE);
            loadImage();

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d=(Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);


            switch(season){
                case "winter":
                    imgName="winter.png";
                    break;
                case "spring":
                    imgName="spring.png";
                    break;
                case "summer":
                    imgName="summer.png";
                case "fall":
                    imgName="fall.png";
                    break;
            }//end switch

            int x=getWidth()/2-img.getWidth(this)/2;
            g2d.drawImage(img, x,0,this);

            g2d.setColor(Color.BLACK);
            g2d.fillRect(DISPLAY_WIDTH/4, DISPLAY_HEIGHT/2, DISPLAY_WIDTH/2, DISPLAY_HEIGHT/6);
            g2d.setColor(Color.white);
            g2d.setFont(new Font("Serif", Font.PLAIN, DISPLAY_HEIGHT/6));
            g2d.drawString(activity,DISPLAY_WIDTH/4, DISPLAY_HEIGHT/2+(DISPLAY_HEIGHT/8));



        }
        public void loadImage(){

            String path = "images/"+imgName;
            File file = new File(path);
            try {
                img = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
