import javax.swing.*;
import java.awt.event.*;

// Main Class
public class StudentRegistrationForm extends JFrame implements ActionListener {

    // Declare components
    JTextField nameField, rollField;
    JTextArea addressArea, outputArea;
    JRadioButton male, female;
    JCheckBox java, python, cpp;
    JButton submit;
    ButtonGroup genderGroup;

    // Constructor
    StudentRegistrationForm() {

        // Set frame properties
        setTitle("Student Registration Form");
        setSize(500,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50,30,100,30);
        add(nameLabel);

        // Name TextField
        nameField = new JTextField();
        nameField.setBounds(150,30,200,30);
        add(nameField);

        // Roll Number Label
        JLabel rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(50,70,100,30);
        add(rollLabel);

        // Roll Number TextField
        rollField = new JTextField();
        rollField.setBounds(150,70,200,30);
        add(rollField);

        // Address Label
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50,110,100,30);
        add(addressLabel);

        // Address TextArea
        addressArea = new JTextArea();
        addressArea.setBounds(150,110,200,60);
        add(addressArea);

        // Gender Label
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50,190,100,30);
        add(genderLabel);

        // Gender Radio Buttons
        male = new JRadioButton("Male");
        male.setBounds(150,190,80,30);

        female = new JRadioButton("Female");
        female.setBounds(240,190,100,30);

        // Group radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // Skills Label
        JLabel skillLabel = new JLabel("Skills:");
        skillLabel.setBounds(50,230,100,30);
        add(skillLabel);

        // Skills Checkboxes
        java = new JCheckBox("Java");
        java.setBounds(150,230,80,30);

        python = new JCheckBox("Python");
        python.setBounds(230,230,80,30);

        cpp = new JCheckBox("C++");
        cpp.setBounds(310,230,80,30);

        add(java);
        add(python);
        add(cpp);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(180,280,100,30);
        submit.addActionListener(this);
        add(submit);

        // Output TextArea
        outputArea = new JTextArea();
        outputArea.setBounds(50,330,380,200);
        add(outputArea);

        // Make frame visible
        setVisible(true);
    }

    // Event handling for Submit button
    public void actionPerformed(ActionEvent e) {

        // Get input values
        String name = nameField.getText();
        String roll = rollField.getText();
        String address = addressArea.getText();

        // Get selected gender
        String gender = "";
        if(male.isSelected())
            gender = "Male";
        else if(female.isSelected())
            gender = "Female";

        // Get selected skills
        String skills = "";
        if(java.isSelected())
            skills += "Java ";
        if(python.isSelected())
            skills += "Python ";
        if(cpp.isSelected())
            skills += "C++ ";

        // Display output
        outputArea.setText("Student Details\n");
        outputArea.append("Name: " + name + "\n");
        outputArea.append("Roll No: " + roll + "\n");
        outputArea.append("Address: " + address + "\n");
        outputArea.append("Gender: " + gender + "\n");
        outputArea.append("Skills: " + skills + "\n");
    }

    // Main Method
    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}