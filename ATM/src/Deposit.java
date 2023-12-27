import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;

import javax.print.attribute.Size2DSyntax;
import javax.sql.ConnectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener
{
	JButton deposit, back;
	JTextField amount ;
	String pinNumber;
	
	public Deposit(String pinNumber) 
	{
		
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text =  new JLabel("Enter The Amount You Want To Depoit");
		text.setBounds(180,220,400,20);
		text.setForeground(Color.WHITE);
		text.setBackground(Color.BLACK);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,20));
		amount.setBounds(170,260,320,20);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355,408,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		back = new JButton("Back");
		back.setBounds(355,440,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		
		setSize(900,900);
		setLocation(280,0);
		setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==deposit) 
		{
			String amt = amount.getText();
			Date date = new Date(ABORT);
			if (amt.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please Enter Amount");
			}
			else 
			{
				try 
				{
				ConnectJdbc c = new ConnectJdbc();
				String query = "insert into bank value('"+pinNumber+"','"+date+"','Deposit','"+amt+"')";
				
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs. "+amt+" Deposit Successfully");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
				}
				catch (Exception e2) 
				{
					System.out.println(e2);
				}
				
			}
			
			
		}
		else if (e.getSource()==back) 
		{
			
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}
	

	public static void main(String[] args) 
	{
		new Deposit("");

	}


	

}
