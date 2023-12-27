package chatapplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import java.net.*;
import java.io.*;


public class Server implements ActionListener
{
	
    JTextField text;
    JPanel p2;
    static DataOutputStream dout;
    static Box verticalBox = Box.createVerticalBox();
    static JFrame frame = new JFrame();

	public Server() 
	{
		frame.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0, 0, 450, 65);
		p1.setLayout(null);
		frame.add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 25, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back = new JLabel(i3);
		back.setBounds(5,10,30,25);
		p1.add(back);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/Saurabh.png"));
		Image i5 = i4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel profile = new JLabel(i6);
		profile.setBounds(40,5,40,40);
		p1.add(profile);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel video = new JLabel(i9);
		video.setBounds(280,10,33,33);
		p1.add(video);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/phone.png"));
		Image i11 = i10.getImage().getScaledInstance(33, 31, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel phone = new JLabel(i12);
		phone.setBounds(340,12,33,31);
		p1.add(phone);
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/3icon.png"));
		Image i14 = i13.getImage().getScaledInstance(15, 28, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel setting = new JLabel(i15);
		setting.setBounds(400,10,15,28);
		p1.add(setting);
		
		JLabel name = new JLabel("Saurabh");
		name.setBounds(90, 5, 100, 30);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		p1.add(name);
		
		JLabel status = new JLabel("Online");
		status.setBounds(90, 33, 100, 30);
		status.setForeground(Color.WHITE);
		status.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
		p1.add(status);
		
		p2 = new JPanel();
		p2.setBounds(0, 70, 450, 560);
		frame.add(p2);
		
		text = new JTextField();
		text.setBounds(1, 635, 350, 50);
		text.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
		frame.add(text);
		
		JButton send = new JButton("Send");
		send.setBounds(350, 635, 100, 50);
		send.setBackground(new Color(7, 94, 84));
		send.setForeground(Color.WHITE);
		send.setFont(new Font("SAN_SARIF", Font.PLAIN, 16));
		send.addActionListener(this);
		frame.add(send);
		
		
		back.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});
		
		frame.setSize(450,685);
		frame.setLocation(200,30);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		
		
		frame.setVisible(true);
	}
	
	//override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		String out = text.getText();
		
		//JLabel output = new JLabel(out);
		
		JPanel p3 = formatLabel(out);
		//p3.add(output);
		
		p2.setLayout(new BorderLayout());
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(p3, BorderLayout.LINE_END);
		verticalBox.add(right);
		verticalBox.add(Box.createVerticalStrut(15));
		p2.add(verticalBox, BorderLayout.PAGE_START);
		
		dout.writeUTF(out);
		
		text.setText("");
		
		frame.repaint();
		frame.invalidate();
		frame.validate();
		}
		catch (Exception ae) {
			ae.printStackTrace();
		}
		
		
	}
	
	public static JPanel formatLabel(String out)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//We can pass out also in JLabel
		JLabel output = new JLabel("<html><p style= \"width: 150px\">"+ out +"</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(220, 248, 198));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,15));
		panel.add(output);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		
		panel.add(time);
		
		return panel;
		
	}
	
	
	public static void main(String[] args) 
	{
		new Server();
		
		try 
		{
			ServerSocket skt = new ServerSocket(6001);
			while(true)
			{
			       Socket s = skt.accept();
			       DataInputStream din = new DataInputStream(s.getInputStream());
			       dout = new DataOutputStream(s.getOutputStream());
			       
			       while(true)
			       {
			    	   String msg = din.readUTF();
			    	   JPanel panel = formatLabel(msg);
			    	   
			    	   JPanel left = new JPanel(new BorderLayout());
			    	   left.add(panel, BorderLayout.LINE_START);
			    	   verticalBox.add(left);
			    	   frame.validate();
			       }
			       
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	

}


