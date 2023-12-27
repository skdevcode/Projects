import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.ChangedCharSetException;

public class PinChange extends JFrame implements ActionListener
{
	
	JButton change,back;
	JPasswordField pin,repin;
	String pinNumber;
	public PinChange(String pinNumber) 
	{
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD,16));
		pintext.setBounds(165,360,180,25);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,16));
		pin.setBounds(330,360,180,25);
		image.add(pin);
		
		
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD,16));
		repintext.setBounds(165,400,180,25);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,16));
		repin.setBounds(330,400,180,25);
		image.add(repin);
		
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==change) 
		{
			
		
		
		  try 
		  {
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if (!npin.equals(rpin)) 
			{
				JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match");
				return;
			}
			if (npin.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please Enter New Pin");
				return;
			}
			if (rpin.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
				return;
			}
			
			ConnectJdbc c = new ConnectJdbc();
			String query =  " update bank set pin = '"+rpin+"' where pin='"+pinNumber+"' ";
			String query1 = " update accountdetails set pin = '"+rpin+"' where pin='"+pinNumber+"' ";
			String query2 = " update login set pin = '"+rpin+"' where pin='"+pinNumber+"' ";
			
			c.s.executeUpdate(query);
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
			
			setVisible(false);
			new Transactions(rpin).setVisible(true);
			
		  } 
		  catch (Exception e2)
		  {
			System.out.println(e2);
		}
		  
	 }
		else 
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
		if (e.getSource()==back) 
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}
	public static void main(String[] args) 
	{
		new PinChange("").setVisible(true);

	}

	

}
