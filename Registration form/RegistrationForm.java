//RgistrationForm
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame{

	private JTextField nameField , emailField, phoneField;
	private  JPasswordField passwordField;
	private JRadioButton maleButton, femaleButton, otherButton;
	private JComboBox <String> countryBox;
	private JCheckBox termsCheck;
	private JButton registerButton, resetButton;
	private ButtonGroup genderGroup;

	//Constructor to initialize the form
	public RegistrationForm(){

	setTitle("User Registration Form");
	setSize(500,450);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setLayout(null);
	
	//name
	JLabel nameLabel = new JLabel("Name :");
	nameLabel.setBounds(30,30,100,25);
	add(nameLabel);
	nameField = new JTextField();
	nameField.setBounds(150,30,200,25);
	add(nameField);

	//email
	JLabel emailLabel = new JLabel("Email :");
	emailLabel.setBounds(30,70,100,25);
	add(emailLabel);
	emailField = new JTextField();
	emailField.setBounds(150,70,200,25);
	add(emailField);

	//Phone
	JLabel phoneLabel = new JLabel("Phone :");
	phoneLabel.setBounds(30,110,100,25);
	add(phoneLabel);
	phoneField = new JTextField();
	phoneField.setBounds(150,110,200,25);
	add(phoneField);

	//Password
	JLabel passwordLabel = new JLabel("Password :  ");
	passwordLabel.setBounds(30,150,100,25);
	add(passwordLabel);
	passwordField = new JPasswordField();
	passwordField.setBounds(150,150,200,25);
	add(passwordField);

	//Gender
	JLabel genderLabel = new JLabel("Gender :");
	genderLabel.setBounds(30,190,100,25);
	add(genderLabel);
	maleButton = new JRadioButton("Male");
	femaleButton = new JRadioButton("Female");
	otherButton = new JRadioButton("Other");
	genderGroup = new ButtonGroup();
	genderGroup.add(maleButton);
	genderGroup.add(femaleButton);
	genderGroup.add(otherButton);
	maleButton.setBounds(150,190,70,25);
	femaleButton.setBounds(230,190,80,25);
	otherButton.setBounds(320,190,90,25);
	add(maleButton);
	add(femaleButton);
	add(otherButton);

	//Country
	JLabel countryLabel = new JLabel("Country :");
	countryLabel.setBounds(30,230,100,25);
	add(countryLabel);
	String[] countries  = {"Select","India","USA","UK","Canada","Austrailia"};
	countryBox = new  JComboBox<>(countries);
	countryBox.setBounds(150,230,200,25);
	add(countryBox);

	//term an condition
	termsCheck = new JCheckBox("I accept the terms and conditions");
	termsCheck.setBounds(30,270,300,25);
	add(termsCheck);

	//Buttons
	registerButton = new JButton("Register");
	registerButton.setBounds(150,310,100,30);
	add(registerButton);
	resetButton = new JButton("Reset");
	resetButton.setBounds(260,310,100,30);
	add(resetButton);


	registerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			String name = nameField.getText();
			String email = emailField.getText();
			String phone = phoneField.getText();
			String password = new String(passwordField.getPassword());
			String gender = maleButton.isSelected()?"Male":
							femaleButton.isSelected()?"Female" :
							otherButton.isSelected()?"Other" : "";

			String country = (String) countryBox.getSelectedItem();
			
			if(!termsCheck.isSelected()){
				JOptionPane.showMessageDialog(RegistrationForm.this, "You must accept the terms and conditions.",
				"Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(RegistrationForm.this,
				"Name: "+ name + "\n"+
				"Email: "+ email + "\n"+
				"Phone: "+ phone + "\n"+
				"Gender: "+ gender + "\n"+
				"Country:"+ country,
				"Registration Info",
				JOptionPane.INFORMATION_MESSAGE
			
			);
		}
	});
	
	//Reset Button
	resetButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			nameField.setText("");
			emailField.setText("");
			phoneField.setText("");
			passwordField.setText("");
			genderGroup.clearSelection();
			countryBox.setSelectedIndex(0);
			termsCheck.setSelected(false);
		}
	});



}
	//Main method to run the application
	public static void main(String arg[]){

		new RegistrationForm().setVisible(true);
	
	}

	
	


}