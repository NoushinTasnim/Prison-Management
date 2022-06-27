package jailor;

public class JailorInfos {

	public String jaiName;
	public String jaiDob; 
	public String jaiJoin;
	public String jaiLeft;
	
	public JailorInfos() {
		// TODO Auto-generated constructor stub
		this.jaiName = new String();
		this.jaiDob = new String();
		this.jaiJoin = new String();
		this.jaiLeft = new String();
	}
	
	public void setJailNm(String priN)
	{
		this.jaiName = (priN);
	}
	
	public String getJailNm()
	{
		return jaiName;
	}

	public void setJailDb(String priN)
	{
		this.jaiDob = (priN);
	}
	
	public String getJailDb()
	{
		return jaiDob;
	}

	public void setJailJoin(String priD)
	{
		this.jaiJoin = (priD);
	}

	public String getJailJoin()
	{
		return jaiJoin;
	}
	
	public void setJailLeft(String priD)
	{
		this.jaiLeft = (priD);
	}
	
	public String getJailLeft()
	{
		return jaiLeft;
	}
	
}
