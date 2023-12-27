import java.awt.Color;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.print.attribute.standard.MultipleDocumentHandling;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Statement;

public class SignupTwo extends JFrame implements ActionListener
{

	
	String formNo;
	JTextField panTextField, aadharTextField ;
	JComboBox<String> religionBox,categoryBox,incomeBox,qualificationBox, occupationBox ;
	JButton next;
	JRadioButton syes, sno, ayes, ano;
	
	public SignupTwo(String formNo)
	{
		this.formNo = formNo;
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		
		JLabel text = new JLabel("Page 2: Additional Details");
		text.setFont(new Font("Areal",Font.BOLD,20));
		text.setBounds(300,60,500,40);
		add(text);
		
		JLabel religion = new JLabel("Religion: ");
		religion.setFont(new Font("Areal",Font.PLAIN,20));
		religion.setBounds(120,120,100,30);
		add(religion);
		
		String valReligion[] = {"Select","Hindu", "Muslim", "Sikh", "Christian", "Others"};
		religionBox = new JComboBox<String>(valReligion);
		religionBox.setBounds(300,125,380,25);
		religionBox.setBackground(Color.WHITE);
		add(religionBox);
		
		
		
		JLabel category = new JLabel("Category: ");
		category.setFont(new Font("Areal",Font.PLAIN,20));
		category.setBounds(120,170,250,30);
		add(category);
		
		String valCategory[] = {"Select","General", "SC", "ST", "OBC", "Others"};
		categoryBox = new JComboBox<String>(valCategory);
		categoryBox.setBounds(300,175,380,25);
		categoryBox.setBackground(Color.WHITE);
		add(categoryBox);
		
		JLabel income = new JLabel("Income: ");
		income.setFont(new Font("Areal",Font.PLAIN,20));
		income.setBounds(120,220,250,30);
		add(income);
		
		String valIncome[] = {"Select","Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		incomeBox = new JComboBox<String>(valIncome);
		incomeBox.setBounds(300,225,380,25);
		incomeBox.setBackground(Color.WHITE);
		add(incomeBox);
		
		JLabel educational = new JLabel("Educational ");
		educational.setFont(new Font("Areal",Font.PLAIN,20));
		educational.setBounds(120,270,250,30);
		add(educational);
		
		
		JLabel qualification = new JLabel("Qualification: ");
		qualification.setFont(new Font("Areal",Font.PLAIN,20));
		qualification.setBounds(120,290,250,30);
		add(qualification);
		
		String valQualification[] = {"Select","Under-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
		qualificationBox = new JComboBox<String>(valQualification);
		qualificationBox.setBounds(300,295,380,25);
		qualificationBox.setBackground(Color.WHITE);
		add(qualificationBox);
		
		JLabel occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Areal",Font.PLAIN,20));
		occupation.setBounds(120,340,250,30);
		add(occupation);
		
		String valoccupation[] = {"Select","Salaried", "Self-Employed", "Business", "Student", "Retired","Others"};
		occupationBox = new JComboBox<String>(valoccupation);
		occupationBox.setBounds(300,345,380,25);
		occupationBox.setBackground(Color.WHITE);
		add(occupationBox);
		
		JLabel panNo = new JLabel("PAN Number: ");
		panNo.setFont(new Font("Areal",Font.PLAIN,20));
		panNo.setBounds(120,390,150,30);
		add(panNo);
		
		panTextField = new JTextField();
		panTextField.setBounds(300,395,380,25);
		panTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(panTextField);
		
		JLabel aadhar = new JLabel("Aadhar Number: ");
		aadhar.setFont(new Font("Areal",Font.PLAIN,20));
		aadhar.setBounds(120,440,150,30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setBounds(300,445,380,25);
		aadharTextField.setFont(new Font("Areal",Font.BOLD,14));
		add(aadharTextField);
		
	
		JLabel senior = new JLabel("Senior Citizen: ");
		senior.setFont(new Font("Areal",Font.PLAIN,20));
		senior.setBounds(120,490,200,30);
		add(senior);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.WHITE);
		syes.setBounds(300,495,80,30);
		add(syes);
		sno = new JRadioButton("No");
		sno.setBackground(Color.WHITE);
		sno.setBounds(380,495,80,30);
		add(sno);
		
		ButtonGroup seniorCitizenGroup = new ButtonGroup();
		seniorCitizenGroup.add(syes);
		seniorCitizenGroup.add(sno);
		
		
		JLabel existAccount = new JLabel("Existing Account: ");
		existAccount.setFont(new Font("Areal",Font.PLAIN,20));
		existAccount.setBounds(120,540,200,30);
		add(existAccount);
		
		ayes = new JRadioButton("Yes");
		ayes.setBackground(Color.WHITE);
		ayes.setBounds(300,545,80,30);
		add(ayes);
		ano = new JRadioButton("No");
		ano.setBackground(Color.WHITE);
		ano.setBounds(380,545,80,30);
		add(ano);
		
		ButtonGroup existAccountGroup = new ButtonGroup();
		existAccountGroup.add(ayes);
		existAccountGroup.add(ano);

		
		
		//Action Button
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(600,600,80,30);
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
		
		
		try 
		{
			
		    String religion   = (String) religionBox.getSelectedItem();
		    String category   = (String) categoryBox.getSelectedItem();
		    String income     = (String) incomeBox.getSelectedItem();
		    String edu        = (String) qualificationBox.getSelectedItem();
		    String occupation = (String) occupationBox.getSelectedItem();
		    
		    String panNo  = panTextField.getText();
		    String aadhar = aadharTextField.getText();
		    
		    String citizen = "";
		    if (syes.isSelected()) 
		    {
				citizen = "Yes";
			}
		    else if (sno.isSelected()) 
		    {
				citizen = "No";
			}
		    
		    String existAccount = "";
		    if (ayes.isSelected()) 
		    {
				existAccount = "Yes";
			}
		    else if (ano.isSelected()) 
		    {
				existAccount = "No";
			}
		    
		
			if (religion == "Select") 
			{
				JOptionPane.showMessageDialog(null, "Select Religion");
			}
			else if (category == "Select") 
			{
				JOptionPane.showMessageDialog(null, "Select Category");
			}
			else if (income == "Select") 
			{
				JOptionPane.showMessageDialog(null, "Select Income");
			}
			else if (edu == "Select") 
			{
				JOptionPane.showMessageDialog(null, "Select Educational Qualification");
			}
			else if (occupation == "Select") 
			{
				JOptionPane.showMessageDialog(null, "Select Occupation");
			}
			else if (panNo.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Pan Number Required");
			}
			else if (aadhar.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Aadhar Number Required");
			}
			else if (citizen.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Select Citizen");
			}
			else if (existAccount.isBlank()) 
			{
				JOptionPane.showMessageDialog(null, "Existing Account Required");
			}
			
			else 
			{
				ConnectJdbc c = new ConnectJdbc();
				String query = "insert into signup2 values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+edu+"','"+occupation+"','"+panNo+"','"+aadhar+"','"+citizen+"','"+existAccount+"')";
				
				c.s.executeUpdate(query);
				
				//Account Details Object
				setVisible(false);
				new AccountDetails(formNo).setVisible(true);
				
				
			}
			
			
		} 
		catch (Exception e2) 
		{
			System.out.println(e2);
		}
		 
	}

	public static void main(String[] args) 
	{
		new SignupTwo("");
		
	}

	
}


