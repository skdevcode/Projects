import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class AccountDetails extends JFrame implements ActionListener
{
	JRadioButton savingAc, fdAc, currentAc, depositAc;
	JButton submitButton, cancelButton;
	JCheckBox atmBox, mobileBox, checqueBox, internetBox, emailBox, statementBox, declarationBox;
	String formNo;
	
	public AccountDetails(String formNo) 
	{
		this.formNo = formNo;
		
		setTitle("Account Details");
		setLayout(null);
		
		JLabel text = new JLabel("Page 3: Account Details");
		text.setFont(new Font("Areal",Font.BOLD,20));
		text.setBounds(270,50,500,40);
		add(text);
		
		JLabel text1 = new JLabel("Account Type");
		text1.setFont(new Font("Areal",Font.BOLD,20));
		text1.setBounds(150,120,300,40);
		add(text1);
		
		
		savingAc = new JRadioButton("Saving Account");
		savingAc.setBackground(Color.WHITE);
		savingAc.setBounds(155,160,120,30);
		add(savingAc);
		
		fdAc = new JRadioButton("Fixed Deposit Account");
		fdAc.setBackground(Color.WHITE);
		fdAc.setBounds(450,160,200,30);
		add(fdAc);
		
		currentAc = new JRadioButton("Current Account");
		currentAc.setBackground(Color.WHITE);
		currentAc.setBounds(155,200,120,30);
		add(currentAc);
		
		depositAc = new JRadioButton("Recurring Deposit Account");
		depositAc.setBackground(Color.WHITE);
		depositAc.setBounds(450,200,200,30);
		add(depositAc);
		
		ButtonGroup accountType = new ButtonGroup();
		accountType.add(savingAc);
		accountType.add(currentAc);
        accountType.add(depositAc);
        accountType.add(fdAc);
        
        JLabel text2 = new JLabel("Card Number: ");
        text2.setFont(new Font("Areal",Font.BOLD,20));
        text2.setBounds(150,260,400,40);
		add(text2);
		JLabel text3 = new JLabel("Your 16-Digit Card Number");
		text3.setFont(new Font("Areal",Font.PLAIN,11));
		text3.setBounds(150,285,150,30);
		add(text3);
		    JLabel card = new JLabel("XXXX-XXXX-XXXX-9884");
		    card.setFont(new Font("Areal",Font.BOLD,20));
		    card.setBounds(330,262,400,40);
			add(card);
		
		JLabel text4 = new JLabel("PIN: ");
		text4.setFont(new Font("Areal",Font.BOLD,20));
		text4.setBounds(150,315,400,40);
		add(text4);
		JLabel text5 = new JLabel("Your 4-Digit Pin");
		text5.setFont(new Font("Areal",Font.PLAIN,11));
		text5.setBounds(150,340,150,30);
		add(text5);
		     JLabel pin = new JLabel("XXXX");
		     pin.setFont(new Font("Areal",Font.BOLD,20));
		     pin.setBounds(330,315,400,40);
		     add(pin);
        
		JLabel text6 = new JLabel("Services Required: ");
		text6.setFont(new Font("Areal",Font.BOLD,20));
		text6.setBounds(150,380,400,40);
		add(text6);
		
		atmBox = new JCheckBox("ATM Card");
		atmBox.setBackground(Color.WHITE);
		atmBox.setBounds(155,420,120,30);
		add(atmBox);
		
		mobileBox = new JCheckBox("Mobile Banking");
		mobileBox.setBackground(Color.WHITE);
		mobileBox.setBounds(155,450,150,30);
		add(mobileBox);
		
		checqueBox = new JCheckBox("Cheque Book");
		checqueBox.setBackground(Color.WHITE);
		checqueBox.setBounds(155,480,150,30);
		add(checqueBox);
        
		
		internetBox = new JCheckBox("Internet Banking");
		internetBox.setBackground(Color.WHITE);
		internetBox.setBounds(450,420,120,30);
		add(internetBox);
		
		emailBox = new JCheckBox("Email & SMS Alert");
		emailBox.setBackground(Color.WHITE);
		emailBox.setBounds(450,450,200,30);
		add(emailBox);
		
		statementBox = new JCheckBox("E-Statement");
		statementBox.setBackground(Color.WHITE);
		statementBox.setBounds(450,480,150,30);
		add(statementBox);
		
		declarationBox = new JCheckBox("I hereby declares that the above details are correct to the best of my knowledge.");
		declarationBox.setFont(new Font("Areal",Font.BOLD,11));
		declarationBox.setBackground(Color.WHITE);
		declarationBox.setBounds(155,550,500,30);
		add(declarationBox);
		
		//Action Buttons
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Raleway",Font.BOLD,14));
		submitButton.setBounds(200,600,100,30);
		submitButton.addActionListener(this);
		add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Raleway",Font.BOLD,14));
		cancelButton.setBounds(450,600,100,30);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		
        
        
        
		getContentPane().setBackground(Color.WHITE);
		setSize(800,720);
		setVisible(true);
		setLocation(300,10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String accountType = null;
		if (savingAc.isSelected())
		{
			accountType = "Saving Account";
		} 
		else if (fdAc.isSelected()) 
		{
			accountType = "Fixed Deposit Account";	
		}
		else if (currentAc.isSelected()) 
		{
			accountType = "Current Account";	
		}
		else if (depositAc.isSelected()) 
		{
			accountType = "Recurring Deposit Account";	
		}
		
		Random random = new Random();
		
		String cardnumber = "" + Math.abs(random.nextLong() % 90000000L) + 34489258L;
		
		String pinNumber = "" + Math.abs(random.nextLong() % 9000L) + 0L;
		
		String services = null;
		if (atmBox.isSelected()) 
		{
		    services = services + "ATM Card";
		}
		else if (mobileBox.isSelected()) 
		{
			services = services + "Mobile Banking";
		}
		else if (checqueBox.isSelected()) 
		{
			services = services + "Checque Book";
		}
		else if (internetBox.isSelected()) 
		{
			services = services + "Internet Banking";
		}
		else if (emailBox.isSelected()) 
		{
			services = services + "Email & SMS Alert";
		}
		else if (statementBox.isSelected()) 
		{
			services = services + "E-Statement";
		}
		
		try 
		{
			if (accountType.isBlank()) 
			{
			    JOptionPane.showMessageDialog(null, "Account Type Required");	
			}
			else if (services.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Please Select Multiple Services");
			}
			else if(e.getSource()==submitButton)
			{
				ConnectJdbc c = new ConnectJdbc();
				String query  = "insert into accountdetails values('"+formNo+"','"+accountType+"','"+cardnumber+"','"+pinNumber+"','"+services+"')";
				String query1 = "insert into login values('"+formNo+"','"+cardnumber+"','"+pinNumber+"')";
				
				
				c.s.executeUpdate(query);
				c.s.executeUpdate(query1);
			}
			
		} catch (Exception e2) 
		{
			System.out.println(e2);
		}
		
		
		
	}

	public static void main(String[] args) 
	{
		new AccountDetails("");

	}

	

}
