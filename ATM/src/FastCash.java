import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener
{
	JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back ;
	String pinNumber;
	
	public FastCash(String pinNumber) 
	{
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(225,300,700,35);
		text.setForeground(Color.WHITE);
		text.setBackground(Color.BLACK);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		hundred = new JButton("Rs 100");
		hundred.setBounds(170,415,150,30);
		hundred.addActionListener(this);
		image.add(hundred);
		
		fiveHundred = new JButton("Rs 500");
		fiveHundred.setBounds(355,415,150,30);
		fiveHundred.addActionListener(this);
		image.add(fiveHundred);
		
		thousand = new JButton("Rs 1000");
		thousand.setBounds(170,450,150,30);
		thousand.addActionListener(this);
		image.add(thousand);
		
		twoThousand = new JButton("Rs 2000");
		twoThousand.setBounds(355,450,150,30);
		twoThousand.addActionListener(this);
		image.add(twoThousand);
		
		fiveThousand = new JButton("Rs 5000");
		fiveThousand.setBounds(170,485,150,30);
		fiveThousand.addActionListener(this);
		image.add(fiveThousand);
		
		tenThousand = new JButton("Rs 10000");
		tenThousand.setBounds(355,485,150,30);
		tenThousand.addActionListener(this);
		image.add(tenThousand);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		
		
		
		
		setSize(900,900);
		setUndecorated(true);
		setLocation(280,0);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getSource()==back) 
		{
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		else 
		{
			String amount = ((JButton)e.getSource()).getText().substring(3);// Rs 100...Here substring(3);skip first 3 character of the string
			ConnectJdbc c = new ConnectJdbc();
			try 
			{
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				
				int balance = 0;
				while (rs.next()) 
				{
					if (rs.getString("type").equals("Deposit")) 
					{
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else 
					{
						balance += Integer.parseInt(rs.getString("amount"));
					}
					
				}
				if (e.getSource()!= back && balance < Integer.parseInt(amount)) 
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Succesfully");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true);
				
				
			}
			catch (Exception e2) 
			{
				System.out.println(e2);
			}
		}
		
		
		
	}

	public static void main(String[] args) 
	{
       
		new FastCash("");


	}

	

}
