import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener
{
	String pinNumber;
	JButton back;

	public MiniStatement(String pinNumber) 
	{
		this.pinNumber = pinNumber;
		
       
        setTitle("Mini Statement");
        
        setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("Kotak Mahindra Bank");
		bank.setBounds(150,20,200,20);
		add(bank);
		
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		
		try 
		{
			ConnectJdbc c = new ConnectJdbc();
			ResultSet rs = c.s.executeQuery(" select * from login where pin= '"+pinNumber+"' ");
			
			while (rs.next()) 
			{
				card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+rs.getString(12));
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		try 
		{
			ConnectJdbc c = new ConnectJdbc();
			ResultSet rs = c.s.executeQuery(" select * from bank where pin= '"+pinNumber+"' ");
			int bal = 0;
			while (rs.next()) 
			{
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><br><html>");
				
				if (rs.getString("type").equals("Deposit")) 
				{
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else 
				{
					bal += Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your Current Account Balance is Rs "+bal);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}
	public static void main(String[] args) 
	{
		new MiniStatement("");

	}
	

}
