package in.ac.adit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Main {
     public static void main(String args[]) {
    	 String url = "jdbc:mysql://localhost:3306/jdbc_db";
    	 String username = "root";
    	 String password = "";
    	 
    	 
    	 try {
    		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
		        st.execute("insert into students(name,email,phone) values('Dhruvin','dhruvinpatel@gmail.com','1597532584')");
			st.execute("insert into students(name,email,phone) values('Pintu','kaleja@gmail.com','1236547896')");
			
			ResultSet rs = st.executeQuery("select * from students");
			while(rs.next()) {
				String id = rs.getString(1);
				System.out.println("id: "+id);
				
				String name = rs.getString(2);
				System.out.println("name: "+name);
				
				String email = rs.getString(3);
				System.out.println("email: "+email);
				
				 String phone = rs.getString(4);
				 System.out.println("phone: "+phone);
				 
				 System.out.println("-------------------------------------");
				 
			}
			
		} catch (ClassNotFoundException | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
