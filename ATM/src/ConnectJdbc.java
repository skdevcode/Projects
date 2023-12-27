import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import com.mysql.cj.xdevapi.Statement;
public class ConnectJdbc 
{
	Connection con;
	Statement s;

	public ConnectJdbc() 
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdatabase?autoReconnect=true&useSSL=false", "root", "Saurabh");
			s = con.createStatement(); 
			
		} catch (Exception e) 
		{
			
			System.out.println(e);
		}
		
	}

	
}
