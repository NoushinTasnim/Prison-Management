package model;

public class SignInModel {

	String user = null , pass = null ;
	
	public SignInModel(String u, String p) {
		//System.out.println(u + " " + p);
		user = u;
		pass = p;
	}
	
	public String loginCheck()
	{
		if (user.isEmpty() || pass.isEmpty()) 
		{
			return "Fields cannot be empty";
		}
		else if(user.equals("admin") && pass.equals("staff1234")) 
		{
			return "1";
		}
		else if(user.equals("admin") && pass.equals("prisoner5678")) 
		{
			return "2";
		}
		else if(user.equals("admin") && pass.equals("jailor")) 
		{
			return "3";
		}
		return "Wrong credentials";
	}
}
