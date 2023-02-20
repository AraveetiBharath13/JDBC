import java.sql.*;
import java.util.*;

class ConnectionTest {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/office";
	    String name = "Bharath";
		
		try {
			Connection con = DriverManager.getConnection(url, "root", "Ab@13446"); 
			// connects with root database
			
			PreparedStatement st = con.prepareStatement("insert into employees values(?)");
			int i = st.executeUpdate(); // Result set stores the data in the original form (Table form)
			st.setString(1, "Bharath");
			ResultSet rs = st.executeQuery("select * from employees");
			
			  while(rs.next()) {
				  
				  System.out.println(rs.getString("name")); 
				  
				  }
			 
			 System.out.println(i + " rows effected");
			/*
			 * int q1 = st.executeUpdate("insert into employees(name,age)" +
			 * "values('sreenath',22)"); System.out.println("insert done!" + q1);
			 */
			st.close();
			con.close();
			
		
	}catch(Exception ex) {
		
	}
		
		
	}
}
