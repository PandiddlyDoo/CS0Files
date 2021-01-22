package Unit1;

import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame {
    /*instance variables can be used anywhere in the class.
    They are used to hold data.
    */
    private JLabel greeting;
    private JTextField input;

    public static void main(String[]args){
        //instantiate an object of the HelloWorld class
        HelloWorld frame=new HelloWorld();
        frame.setSize(300,300);
        frame.setUpGUI();//this is the method call for setUpGUI
        frame.setVisible(true);
    }

    /*
    * A method is a reusable portion of the code
    * We will get into more detail on methods in a future unit
    * This is the method definition, it is not active living
    * breathing code until it is invoked or called.
    * In other words, this code is only run when the method
    * call takes place.  See above in the main for the method call
    * */
    public void setUpGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*This will get the container that holds all components
         to be added to the Frame.
          */
        Container window = getContentPane();
        //we can call methods to the wondow object
        /*See the API for a list of methods
        available to the Container class:
        https://docs.oracle.com/javase/7/docs/api/java/awt/Container.html
        */
        window.setLayout(new FlowLayout());
        greeting=new JLabel("Hello World!");
        input=new JTextField("Input text here", 25);

        /*In order for components to show up in a Frame
        we need to add them to the content pane
        */
        /*by stating window.add(something)
        we are choosing the window object to add a
        component into.
        */
        window.add(greeting);
        window.add(input);
    }
}
