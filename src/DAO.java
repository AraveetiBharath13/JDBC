import java.util.*;
import java.sql.*;

public class DAO {
	
	public static void main(String[] args) {
	
	 StudentDAO dao = new StudentDAO();
	 
     //Student s1 = dao.getStudent(10);
     Student s2 = new Student();
     s2.rollno = 12;
     s2.fname = "suresh";
     s2.name = "sharath";
     s2.marks = 100;
     
     dao.addStudent(s2);
     
    // System.out.println(s1.name);
     
	}

}

class StudentDAO{
	Student s = new Student();
	String url = "jdbc:mysql://localhost:3306/school";
	
	public Student getStudent(int rollno) {
		
		
		s.rollno = rollno;
		String n;
		
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "Ab@13446");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select name from students where rollno = " + rollno );
			rs.next();
			n = rs.getString(1);
			s.name = n;
			
			
			
		}catch(Exception ex) {
			
		}
		
		return s;
		
	}
	
	public void addStudent(Student s) {
		
		try {
			
			Connection conn = DriverManager.getConnection(url,"root","Ab@13446");
			PreparedStatement ps = conn.prepareStatement("insert into students values(?,?,?,?)");
			ps.setInt(1, s.rollno);
			ps.setString(2, s.name);
			ps.setString(3, s.fname);
			ps.setInt(4, s.marks);
			int i = ps.executeUpdate();
			
			
			System.out.println("no.of rows effected " + i);
			//return s;
			
		}catch(Exception ex) {
			
		}
	}
	
	
}

class Student{
	
	String name;
	int rollno;
	String fname;
    int marks;
	
		
	}

