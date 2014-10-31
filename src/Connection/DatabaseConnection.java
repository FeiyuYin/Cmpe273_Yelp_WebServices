package Connection;

import java.sql.*;


public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	
	public DatabaseConnection(){		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","12345678");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("Successfully Connected");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public String signUp(String email, String password, String firstname, String lastname, String zipcode){
		String result = "";
		int rowcount;
		try {
			String query = "Insert into users (email, password, firstname, lastname, zipcode) values ('" + email + "', '" + password + "', '" + firstname + "', '" + lastname + "', '" + zipcode + "')";
			rowcount=stmt.executeUpdate(query);
			if(rowcount > 0){
				result="true";
				System.out.println("Insert Successful");
			}
			else{
				result="false: The data could not be inserted in the database.";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean signIn(String email, String password){
	
		int rowcount;
		try {
			String query = "select password from users where email = '" + email + "'";
			ResultSet result = stmt.executeQuery(query);
			if(result.first() == false){return false;}
			else{
				
				String p = result.getString("password");
				System.out.println(p);
				if(p.equals(password)){
					
					return true;
				}
				else{return false;}
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
