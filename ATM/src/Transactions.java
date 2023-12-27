import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener
{
	JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balEnquiry, exit ;
	String pinNumber;
	
	public Transactions(String pinNumber) 
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(225,300,700,35);
		text.setForeground(Color.WHITE);
		text.setBackground(Color.BLACK);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal = new JButton("Cash Withdrawal");
		withdrawal.setBounds(355,415,150,30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170,450,150,30);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355,450,150,30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170,485,150,30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balEnquiry = new JButton("Balance Enquery");
		balEnquiry.setBounds(355,485,150,30);
		balEnquiry.addActionListener(this);
		image.add(balEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		
		
		
		
		setSize(900,900);
		setUndecorated(true);
		setLocation(280,0);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getSource()==exit) 
		{
			System.exit(0);
		}
		else if (e.getSource()==deposit) 
		{
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}
		else if (e.getSource()==withdrawal)
		{
			setVisible(false);
			new Withdrawal(pinNumber).setVisible(true);
		}
		else if (e.getSource()==fastCash) 
		{
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		if (e.getSource()==pinChange) 
		{
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		if (e.getSource()==balEnquiry) 
		{
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}
		if (e.getSource()==miniStatement) 
		{
			
			new MiniStatement(pinNumber).setVisible(true);
		}
		
		
	}

	public static void main(String[] args) 
	{
       
		new Transactions("");


	}

	

}
