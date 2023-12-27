import java.awt.Color;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import java.sql.Statement;

public class SignupOne extends JFrame implements ActionListener
{

	long random;
	JLabel formNo;
	JTextField nameTextField, fatherTextField, emailTextField,
	           addressTextField, cityTextField, stateTextField, pinTextField;
	
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;
	
	public SignupOne()
	{
		//To Generate 4 digits Random Number
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L)+1000L);
		
		formNo = new JLabel("APPLICATION FORM NO. "+random);
		formNo.setFont(new Font("Raleway",Font.BOLD,38));
		formNo.setBounds(140,10,600,40);
		add(formNo);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		setLayout(null);
		
		JLabel text = new JLabel("Page 1: Personal Details");
		text.setFont(new Font("Areal",Font.BOLD,20));
		text.setBounds(300,60,500,40);
		add(text);
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Areal",Font.PLAIN,20));
		name.setBounds(120,120,100,30);
		add(name);
		
		JLabel fatherName = new JLabel("Father's Name: ");
		fatherName.setFont(new Font("Areal",Font.PLAIN,20));
		fatherName.setBounds(120,180,250,30);
		add(fatherName);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Areal",Font.PLAIN,20));
		dob.setBounds(120,230,250,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,230,380,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Areal",Font.PLAIN,20));
		gender.setBounds(120,280,250,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setBounds(300,285,60,30);
		add(male);
		female = new JRadioButton("Female");
		female.setBackground(Color.WHITE);
		female.setBounds(450,285,90,30);
		add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		JLabel email = new JLabel("Email Address: ");
		email.setFont(new Font("Areal",Font.PLAIN,20));
		email.setBounds(120,330,250,30);
		add(email);
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setFont(new Font("Areal",Font.PLAIN,20));
		marital.setBounds(120,380,150,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBackground(Color.WHITE);
		married.setBounds(300,380,80,30);
		add(married);
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.WHITE);
		unmarried.setBounds(450,380,90,30);
		add(unmarried);
		other = new JRadioButton("Other");
		other.setBackground(Color.WHITE);
		other.setBounds(600,380,90,30);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Areal",Font.PLAIN,20));
		address.setBounds(120,430,200,30);
		add(address);
		
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Areal",Font.PLAIN,20));
		city.setBounds(120,480,200,30);
		add(city);
		
		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Areal",Font.PLAIN,20));
		state.setBounds(120,550,200,30);
		add(state);
		
		JLabel pinCode = new JLabel("Pin Code: ");
		pinCode.setFont(new Font("Areal",Font.PLAIN,20));
		pinCode.setBounds(120,600,200,30);
		add(pinCode);
		
		//Text Fields
		nameTextField = new JTextField();
		nameTextField.setBounds(300,125,380,25);
		nameTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(nameTextField);
		
		fatherTextField = new JTextField();
		fatherTextField.setBounds(300,185,380,25);
		fatherTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(fatherTextField);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(300,335,380,25);
		emailTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(emailTextField);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(300,435,380,25);
		addressTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(addressTextField);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(300,485,380,25);
		cityTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(cityTextField);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(300,555,380,25);
		stateTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(stateTextField);
		
		
		pinTextField = new JTextField();
		pinTextField.setBounds(300,605,380,25);
		pinTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(pinTextField);
		
		
		//Action Button
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(600,650,80,30);
		next.addActionListener(this);
        add(next);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,720);
		setVisible(true);
		setLocation(300,10);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String formNo = "" + random;//long
		String name = nameTextField.getText();
		String father = fatherTextField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = "";
		if (male.isSelected()) 
		{
			gender = "Male";
		}
		else if (female.isSelected()) 
		{
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = "";
		if (married.isSelected()) 
		{
			marital = "Married";
		} 
		else if (unmarried.isSelected()) 
		{
			marital = "Unmarried";
		}
		else if (other.isSelected())
		{
			marital = "Other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();
		
		
		try 
		{
			if (name.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Name Required");
			}
			else if (father.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Father's Name Required");
			}
			else if (dob.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Date of Birth Required");
			}
			else if (gender.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Select Gender");
			}
			else if (email.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Email Required");
			}
			else if (marital.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Select Marital Status");
			}
			else if (address.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Address Required");
			}
			else if (city.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "City Required");
			}
			else if (state.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "State Required");
			}
			else if (pin.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Pin Code Required");
			}
			else if (e.getSource() == next) 
			{
				setVisible(false);
				new SignupTwo("").setVisible(true);
			}
			
			else 
			{
				ConnectJdbc c = new ConnectJdbc();
				String query = "insert into signup values('"+formNo+"','"+name+"','"+father+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
				
				c.s.executeUpdate(query);
				
				
			}
			
			
		} 
		catch (Exception e2) 
		{
			System.out.println(e2);
		}
		 
	}

	public static void main(String[] args) 
	{
		new SignupOne();
		
	}

	
}


