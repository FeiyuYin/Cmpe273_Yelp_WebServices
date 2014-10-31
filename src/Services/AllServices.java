package Services;
import javax.jws.WebService;

import Connection.DatabaseConnection;

@WebService
public class AllServices {

	DatabaseConnection db=new DatabaseConnection();
	
	public String signUp(String email, String password, String firstname, String lastname, String zipcode)
	{
		System.out.println("Inside Signup");
		String result;
		
		result = db.signUp(email, password, firstname, lastname, zipcode);
		
		return result;//this value is returned to the calling servlet
	}
	
	public boolean signIn(String email, String password)
	{
		System.out.println("Inside Signin");
		boolean result = false;
		
		result = db.signIn(email, password);
		
		return result;//this value is returned to the calling servlet
	}
}
