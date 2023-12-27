import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class Login extends JFrame implements ActionListener
{
	
	JButton signinButton, clear, signupButton;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	public Login() 
	{
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		// Placed ATM Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(140, 10, 100, 100);
		add(label);
		
		// Heading of ATM
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(270,40,400,40);
		add(text);
		
		JLabel cardno = new JLabel("CARD NO: ");
		cardno.setFont(new Font("Raleway",Font.BOLD,22));
		cardno.setBounds(180,150,400,40);
		add(cardno);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(180,220,400,40);
		add(pin);
		
		
		// Text Fields
		cardTextField = new JTextField();
		cardTextField.setBounds(300,160,300,25);
		cardTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(cardTextField);
		
		pinTextField = new JPasswordField(6);
		pinTextField.setBounds(300,230,300,25);
		pinTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(pinTextField);
		
		//Action Buttons
	    signinButton = new JButton("SIGN IN");
        signinButton.setBounds(300,280,100,30);
        signinButton.setBackground(new Color(27, 18, 18));
        signinButton.setForeground(Color.WHITE);
       // signinButton.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
        signinButton.addActionListener(this);
        add(signinButton);
        
        clear = new JButton("CLEAR");
        clear.setBounds(500,280,100,30);
        clear.setBackground(new Color(27, 18, 18));
        clear.setForeground(Color.WHITE);
       // clear.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
        clear.addActionListener(this);
        add(clear);
        
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(300,330,300,30);
        signupButton.setBackground(new Color(27, 18, 18));
        signupButton.setForeground(Color.WHITE);
       // signupButton.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
        signupButton.addActionListener(this);
        add(signupButton);
        
        
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(300,150);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
      
       if (e.getSource()==clear)
       {
    	   cardTextField.setText("");
    	   pinTextField.setText("");
       }
       else if (e.getSource()==signinButton) 
       {
		   ConnectJdbc conn = new ConnectJdbc();
		   String cardNumber = cardTextField.getText();
		   String pinNumber = pinTextField.getText();
		   
		   
		   String query = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
		   
		   try 
		   {
			   ResultSet rs = conn.s.executeQuery(query);
			   if (rs.next()) 
			   {
				   setVisible(false);
				   new Transactions(pinNumber).setVisible(true);
			   }
			   else 
			   {
				   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				
			   }
			
		   } 
		   catch (Exception e2) 
		   {
			System.out.println(e2);
		   }
		   
	   }
       else if (e.getSource()==signupButton) 
       {
    	   
    	   setVisible(false);
		   new SignupOne().setVisible(true);
	   }
    }
		

	public static void main(String[] args) 
	{
		new Login();

	}

	

}
