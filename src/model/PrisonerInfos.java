package model;

public class PrisonerInfos {
	
	public String nameProp, dobProp, genProp, hgtProp, cellProp, bgProp;
	public String crmProp, crmDesProp, crmEntProp, crmRelProp; 
	public String prevCrmProp, prevDesProp, prevEntProp, prevRelProp;
	public String idProp;
	
	public static String[] wing = {"A","B","C","D"};
	
	public static String[] cell_no = {	"01","02","03","04",
										"05","06","07","08",
										"09","10","11","12",
										"13","14","15","16"	};
	
	public static String[] crime = {	"Murder","Burglary","Kidnapping",
										"Antisocial Behaviour","Arson",
										"Domestic Abuse","Fraud",
										"Cyber Crime","Rape","Hate Crime",
										"Modern Slavery","Child Abuse"};
	
	public static String[] bg = {"A+","B+","AB+","O+","A-","B-","AB-","O-"};
	
	public static String[] heightIn = {"0 inch","1 inches","2 inches","3 inches",
										"4 inches","5 inches","6 inches","7 inches",
										"8 inches","9 inches","10 inches","11 inches"};
	
	public static String[] heightFt = {"3 ft","4 ft","5 ft","6 ft","7 ft"};

	public PrisonerInfos() {
		// TODO Auto-generated constructor stub
		this.nameProp = new String();
		this.dobProp = new String();
		this.genProp = new String();
		this.hgtProp = new String();
		this.cellProp = new String();
		this.bgProp = new String();
		this.crmProp = new String();
		this.crmDesProp = new String();
		this.crmEntProp = new String();
		this.crmRelProp = new String();
		this.prevCrmProp = new String();
		this.prevDesProp = new String();
		this.prevEntProp = new String();
		this.prevRelProp = new String();
	}
	
	public void setPriId(String priN)
	{
		this.idProp = (priN);
	}
	
	public String getIdProp()
	{
		return idProp;
	}

	public void setPriName(String priN)
	{
		this.nameProp = (priN);
	}
	
	public String getNameProp()
	{
		return nameProp;
	}

	public void setPriDob(String priD)
	{
		this.dobProp = (priD);
	}

	public String getDobProp()
	{
		return dobProp;
	}
	
	public void setPriGen(String priD)
	{
		this.genProp = (priD);
	}
	
	public String getGenProp()
	{
		return genProp;
	}
	
	public void setPriHgt(String priD)
	{
		this.hgtProp = (priD);
	}
	
	public String getHgtProp()
	{
		return hgtProp;
	}
		
	public void setPriCell(String priD)
	{
		this.cellProp = (priD);
	}
	
	public String getCellProp()
	{
		return cellProp;
	}

	public void setPriBg(String priD)
	{
		this.bgProp = priD;
	}
	
	public String getBgProp()
	{
		return bgProp;
	}
	
	public void setPriCrm(String priD)
	{
		this.crmProp = (priD);
	}
	
	public String getCrmProp()
	{
		return crmProp;
	}
	
	public void setPriDes(String priD)
	{
		this.crmDesProp = (priD);
	}
	
	public String getPriDes()
	{
		return crmDesProp;
	}
	
	public void setPriEnt(String priD)
	{
		this.crmEntProp = priD;
	}
	
	public String getEntProp()
	{
		return crmEntProp;
	}
	
	public void setPriRel(String priD)
	{
		this.crmRelProp = priD;
	}
	
	public String getRelProp()
	{
		return crmRelProp;
	}
	
	public String getPriPreC()
	{
		return prevCrmProp;
	}
	
	public void setPriPreC(String priD)
	{
		this.prevCrmProp = (priD);
	}
	
	public String getPriPreD()
	{
		return prevDesProp;
	}
	
	public void setPriPreD(String priD)
	{
		this.prevDesProp = (priD);
	}
	
	public String getPriPreE()
	{
		return prevEntProp;
	}
	
	public void setPriPreE(String priD)
	{
		this.prevEntProp = (priD);
	}
	
	public String getPriPreR()
	{
		return prevRelProp;
	}
	
	public void setPriPreR(String priD)
	{
		this.prevRelProp = (priD);
	}
}
