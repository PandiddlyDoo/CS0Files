import javax.swing.*;
import java.awt.*;

/**
 * Created by Charlie Gorrill on 4/3/2019.
 */
public class AddressFields extends JPanel {
    JLabel name, street, city, state, zip, typeLabel;
    JTextField nameField, streetField, cityField, stateField, zipField;
    JPanel container;
    GridLayout grid;
    String addressType;

    public AddressFields(String type) {
        addressType=type;
        container=new JPanel();
        grid = new GridLayout(5, 2);
        setLayout(new BorderLayout());
        container.setLayout(grid);

        typeLabel=new JLabel(addressType, JLabel.CENTER);
        add(typeLabel, BorderLayout.NORTH);

        createLables();
        createFields();
        addComponents();
    }

    public void clearFields(){
        nameField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipField.setText("");
    }

    public void createLables() {
        name = new JLabel("Name: ", JLabel.RIGHT);
        street = new JLabel("Street: ", JLabel.RIGHT);
        city = new JLabel("City: ", JLabel.RIGHT);
        state = new JLabel("State: ", JLabel.RIGHT);
        zip = new JLabel("Zip: ", JLabel.RIGHT);
    }

    public void createFields() {
        nameField = new JTextField(10);
        streetField = new JTextField(10);
        cityField = new JTextField(10);
        stateField = new JTextField(10);
        zipField = new JTextField(10);
    }

    public void addComponents() {
        container.add(name);
        container.add(nameField);
        container.add(street);
        container.add(streetField);
        container.add(city);
        container.add(cityField);
        container.add(state);
        container.add(stateField);
        container.add(zip);
        container.add(zipField);
        add(container, BorderLayout.CENTER);

    }

}
